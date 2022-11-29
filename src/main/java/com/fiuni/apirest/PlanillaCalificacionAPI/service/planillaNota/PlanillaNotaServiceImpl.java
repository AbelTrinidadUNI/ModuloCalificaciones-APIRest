package com.fiuni.apirest.PlanillaCalificacionAPI.service.planillaNota;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.detallePN.IDetallePNDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dao.planillaNota.IPlanillaNotaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaTablaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.*;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.detallePN.DetallePlanillaNotaServiceImpl;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.etapa.utils.Settings;
import com.library.domainLibrary.domain.detallePN.DetallePlanillaNotaDomain;
import com.library.domainLibrary.domain.planillaNota.PlanillaNotaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlanillaNotaServiceImpl extends BaseServiceImpl<PlanillaNotaDto, PlanillaNotaDomain, PlanillaNotaResult> implements IPlanillaNotaService {

    @Autowired
    private IPlanillaNotaDao pNotas;
    @Autowired
    private DetallePlanillaNotaServiceImpl detallesNotas;

    @Autowired
    private IDetallePNDao detallesDao;

    @Autowired
    private CacheManager cacheManager;


    @Override
    public PlanillaNotaDto save(PlanillaNotaDto dto) {
        dto.setEstado(dto.getEstado() == null ? true : dto.getEstado());

        PlanillaNotaDto response = convertDomainToDto(pNotas.save(convertDtoToDomain(dto)));

        List<DetallePlanillaNotaDTO> responseDet = new ArrayList<>();
        dto.getDetalles().forEach(det -> {
            det.setIdPlanillaNota(response.getId());
            det.setEstado(true);
            DetallePlanillaNotaDTO detDto = detallesNotas.save(det);

            if (detDto.getId() == null) {
                cacheManager.getCache(Settings.CACHE_NAME)
                        .put("API_DETALLES_PN_" + detDto.getId(), detDto);
            }
            //detallesNotas.save(det);
            responseDet.add(detDto);
        });

        response.setDetalles(responseDet);

        if (dto.getId() == null) {
            cacheManager.getCache(Settings.CACHE_NAME)
                    .put("API_PLANILLA_NOTA_" + response.getId(), response);
        }

        return response;
    }

    @Override
    @Transactional
    @Cacheable(value = Settings.CACHE_NAME, key = "'API_PLANILLA_NOTA_' + #id")
    public PlanillaNotaDto getById(Integer id) throws Exception {
        PlanillaNotaDto response = pNotas.findById(id)
                .map(p -> convertDomainToDto(p)).orElse(null);

        return response;
    }

    @Override
    public PlanillaNotaResult getAll(Pageable pageable) {


        //Page<PlanillaNotaDomain> page = pNotas.findAll(pageable);

        Page<PlanillaNotaDomain> page = pNotas.getByEstadoTrue(pageable);


        if (page != null) {
            PlanillaNotaResult response = new PlanillaNotaResult(
                    page.map(p -> {
                                PlanillaNotaDto dtoPN = convertDomainToDto(p);
                                cacheManager.getCache(Settings.CACHE_NAME)
                                        .put("API_PLANILLA_NOTA_" + dtoPN.getId(), dtoPN);

                                dtoPN.getDetalles().forEach(det -> {
                                    cacheManager.getCache(Settings.CACHE_NAME)
                                            .put("API_DETALLES_PN_" + det.getId(), det);
                                });
                                return dtoPN;
                            }
                    ).toList());

            response.setTotalPages(page.getTotalPages());

            return response != null && response.getTotal() > 0 ? response
                    : null;
        }
        return null;
    }


    @Override
    @Transactional
    public PlanillaNotaDto update(Integer id, PlanillaNotaDto dto) {
        if (dto.getEstado() != null && dto.getIdListaMateria() != null) {
            PlanillaNotaDto response = pNotas.findById(id).map(d -> {

                d.setEstado(dto.getEstado());
                d.setIdListaMateria(dto.getIdListaMateria());

                //guardo los detalles
                dto.getDetalles().forEach(det -> {

                    cacheManager.getCache(Settings.CACHE_NAME)
                            .evictIfPresent("API_DETALLES_PN_" + det.getId());

                    detallesNotas.save(det);
                });
                //gurado la cavecera
                dto.setId(d.getId());

                cacheManager.getCache(Settings.CACHE_NAME)
                        .put("API_PLANILLA_NOTA_" + dto.getId(), dto);

                return save(dto);
            }).orElse(null) != null ? dto : null;

            return response;
        }
        return null;
    }

    @Override
    @Transactional
    public Boolean delete(Integer id) {
        Boolean response = pNotas.delete(id);

        if (response != null && response) {
            //se elimina del cache la cabecera
            cacheManager.getCache(Settings.CACHE_NAME)
                    .evictIfPresent("API_PLANILLA_NOTA_" + id);

            List<DetallePlanillaNotaDomain> detallesDomain = detallesDao.getAllByIdPlanillaNota(id);

            detallesDomain.stream().forEach(val -> {
                Boolean ret = detallesNotas.delete(val.getId());

                if (ret != null && ret) {
                    //se elimina del cache el detalle
                    cacheManager.getCache(Settings.CACHE_NAME)
                            .evictIfPresent("API_DETALLES_PN_" + val.getId());
                }
            });
        }

        return response;
    }

    @Override
    public PlanillaNotaTablaDTO findByIdListaMateria(Integer id) {
        try {
            PlanillaNotaTablaDTO response = new PlanillaNotaTablaDTO();

            PlanillaNotaDomain pn = pNotas.findFirstByIdListaMateriaAndEstadoTrue(id);

            if (pn == null){
                System.out.println("PN es nulo");
            }


            response.setId(pn.getId());
            response.setIdListaMateria(pn.getIdListaMateria());
            response.setIdMateria(pn.getListaMateria().getIdMateria());
            response.setIdCiclo(pn.getListaMateria().getClase().getIdCiclo());
            response.setIdClase(pn.getListaMateria().getIdClase());
            response.setIdColegio(pn.getListaMateria().getClase().getIdColegio());
            response.setIdProfesor(pn.getListaMateria().getIdProfesor());
            response.setAnhoClase(pn.getListaMateria().getClase().getAnho());
            response.setDescripcionCiclo(pn.getListaMateria().getClase().getCiclo().getDescripcion());
            response.setNombreClase(pn.getListaMateria().getClase().getNombre());
            response.setNombreMateria(pn.getListaMateria().getMateria().getNombre());
            response.setNombreColegio(pn.getListaMateria().getClase().getColegio().getNombreColegio());
            response.setNombreProfesor(pn.getListaMateria().getProfesor().getNombre());
            response.setTurnoClase(pn.getListaMateria().getClase().getTurno());

            List<DetallePlanillaNotaTablaDTO> listaDetalles = new ArrayList();
            for (int i = 0; i < pn.getDetallesPlanillaNotas().size(); i++) {
                DetallePlanillaNotaDomain det = pn.getDetallesPlanillaNotas().get(i);

                if (det.getEstado()) {
                    DetallePlanillaNotaTablaDTO detalle = new DetallePlanillaNotaTablaDTO();
                    detalle.setId(det.getId());
                    detalle.setIdAlumno(det.getListaAlumno().getAlumno().getId());
                    detalle.setIdListaAlumno(det.getIdListaAlumno());
                    detalle.setIdEvaluacion(det.getIdEvaluacion());
                    detalle.setIdEtapa(det.getEvaluacion().getIdEtapa());
                    detalle.setDescripcionEtapa(det.getEvaluacion().getEtapa().getDescripcion());
                    detalle.setPuntaje(det.getPuntaje());
                    detalle.setObservacion(det.getObservacion());
                    detalle.setDescripcionEvaluacion(det.getEvaluacion().getNombre());
                    detalle.setNombreAlumno(det.getListaAlumno().getAlumno().getNombre());
                    detalle.setDescripcionEtapa(det.getEvaluacion().getEtapa().getDescripcion());
                    detalle.setTPEvaluacion(det.getEvaluacion().getTotalPunto());

                    listaDetalles.add(detalle);
                }
            }
            response.setDetalles(listaDetalles);

            return response;
        /*return response != null ? new ResponseEntity<PlanillaNotaTableableDTO>(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);*/
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
            return null;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    @Transactional
    public Boolean updatePuntajeAndEstado(PlanillaNotaUpdNotasAndEstadoDTO dto) {
            try{
                dto.getDetalles().forEach(d -> {
                    //System.out.println("id: " + d.getId() + " puntaje: " + d.getPuntaje() + " estado: " + d.getEstado());
                    detallesDao.updatePuntajeAndEstado(d.getPuntaje(), d.getEstado(), d.getId());
                });
                return true;
            }catch(Exception e) {
                System.out.println(e.getMessage());
                return false;
            }
    }


    @Override
    public PlanillaNotaDto convertDomainToDto(PlanillaNotaDomain domain) {
        PlanillaNotaDto dto = new PlanillaNotaDto();
        dto.setId(domain.getId());
        dto.setEstado(domain.getEstado());
        dto.setIdListaMateria(domain.getIdListaMateria());
        List<DetallePlanillaNotaDTO> dtoDetalles = new ArrayList<>();
        if(domain.getDetallesPlanillaNotas() != null) {
            domain.getDetallesPlanillaNotas().stream().forEach(d -> {
                DetallePlanillaNotaDTO dtoDet = new DetallePlanillaNotaDTO();
                dtoDet.setId(d.getId());
                dtoDet.setEstado(d.getEstado());
                dtoDet.setObservacion(d.getObservacion());
                dtoDet.setIdPlanillaNota(d.getIdPlanillaNota());
                dtoDet.setIdEvaluacion(d.getIdEvaluacion());
                dtoDet.setIdListaAlumno(d.getIdListaAlumno());
                dtoDet.setPuntaje(d.getPuntaje());

                dtoDetalles.add(dtoDet);
            });

        }
        dto.setDetalles(dtoDetalles);


        return dto;
    }

    @Override
    public PlanillaNotaDomain convertDtoToDomain(PlanillaNotaDto dto) {
        PlanillaNotaDomain domain = new PlanillaNotaDomain();
        domain.setId(dto.getId());
        domain.setIdListaMateria(dto.getIdListaMateria());
        domain.setEstado(dto.getEstado());

        return domain;
    }


}
