package com.fiuni.apirest.PlanillaCalificacionAPI.service.planillaNota;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.detallePN.IDetallePNDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dao.planillaNota.IPlanillaNotaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaConEvaluacionDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaDto;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaTableableDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.detallePN.DetallePlanillaNotaServiceImpl;
import com.fiuni.apirest.PlanillaCalificacionAPI.utils.Settings;
import com.library.domainLibrary.domain.detallePN.DetallePlanillaNotaDomain;
import com.library.domainLibrary.domain.planillaNota.PlanillaNotaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    public PlanillaNotaTableableDTO findByIdListaMateria(Integer id) {
        PlanillaNotaTableableDTO response = new PlanillaNotaTableableDTO();

        PlanillaNotaDomain pn = pNotas.findFirstByIdListaMateria(id);


        DetallePlanillaNotaServiceImpl aux = new DetallePlanillaNotaServiceImpl();

        response.setId(pn.getId());
        response.setNombreMateria(pn.getListaMateria().getMateria().getNombre());
        response.setDescripcionClase(pn.getListaMateria().getClase().getNombre());
        response.setIdListaMateria(pn.getIdListaMateria());

        List<DetallePlanillaNotaConEvaluacionDTO> listaDetalles = new ArrayList();
        for (int i = 0; i < pn.getDetallesPlanillaNotas().size(); i++) {
            listaDetalles.add(aux.convertDomainToDto2(pn.getDetallesPlanillaNotas().get(i)));
        }
        response.setDetallesNotas(listaDetalles);

        return response;
        /*return response != null ? new ResponseEntity<PlanillaNotaTableableDTO>(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);*/
    }


    @Override
    protected PlanillaNotaDto convertDomainToDto(PlanillaNotaDomain domain) {
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
    protected PlanillaNotaDomain convertDtoToDomain(PlanillaNotaDto dto) {
        PlanillaNotaDomain domain = new PlanillaNotaDomain();
        domain.setId(dto.getId());
        domain.setIdListaMateria(dto.getIdListaMateria());
        domain.setEstado(dto.getEstado());

        return domain;
    }


}
