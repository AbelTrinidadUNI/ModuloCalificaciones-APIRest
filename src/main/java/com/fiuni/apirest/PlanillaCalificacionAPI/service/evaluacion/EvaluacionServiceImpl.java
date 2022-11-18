package com.fiuni.apirest.PlanillaCalificacionAPI.service.evaluacion;

import com.fiuni.apirest.PlanillaCalificacionAPI.dao.detallePN.IDetallePNDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dao.etapa.IEtapaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dao.evaluacion.IEvaluacionDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionNuevaEnTablaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.detallePN.IDetallePlanillaNotaService;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.etapa.EtapaServiceImpl;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.etapa.IEtapaService;
import com.fiuni.apirest.PlanillaCalificacionAPI.utils.Settings;
import com.library.domainLibrary.domain.etapa.EtapaDomain;
import com.library.domainLibrary.domain.evaluacion.EvaluacionDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EvaluacionServiceImpl extends BaseServiceImpl<EvaluacionDTO, EvaluacionDomain, EvaluacionResult> implements IEvaluacionService {
    @Autowired(required = true)
    private IEvaluacionDao evaluacionDao;
    @Autowired(required = true)
    private IEtapaDao etapaDao;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private IDetallePNDao detallePNDao;

    //@Autowired
    //private IEtapaService etapaService;


    @Autowired
    private IDetallePlanillaNotaService detallePNService;

    @Override
    @Transactional
    public EvaluacionDTO save(EvaluacionDTO dto) {
        dto.setEstado(dto.getEstado() == null || dto.getEstado());

        EvaluacionDTO response = convertDomainToDto(evaluacionDao.save(convertDtoToDomain(dto)));

        if (dto.getId() == null) {
            cacheManager.getCache(Settings.CACHE_NAME).put("API_EVALUACION_" + response.getId(), response);
        }
        return response;
    }


    @Override
    @Transactional
    @Cacheable(value = Settings.CACHE_NAME, key = "'API_EVALUACION_' + #id")
    public EvaluacionDTO getById(Integer id) {
        EvaluacionDTO response = evaluacionDao.findById(id).map(evaluacionDomain -> convertDomainToDto(evaluacionDomain)).orElse(null);

        return response;
    }

    @Override
    @Transactional
    public EvaluacionResult getAll(Pageable pageable) {
        /*EvaluacionResult response = new EvaluacionResult(evaluacionDao.findAll(pageable).map(evaluacion -> {
                    EvaluacionDTO dto = convertDomainToDto(evaluacion);
                    cacheManager.getCache(Settings.CACHE_NAME).putIfAbsent("API_EVALUACION_" + dto.getId(), dto);
                    return dto;
                }).toList());
        */
        Page<EvaluacionDomain> page = evaluacionDao.getByEstadoTrue(pageable);
        EvaluacionResult response = new EvaluacionResult(page.map(evaluacion -> {
            EvaluacionDTO dto = convertDomainToDto(evaluacion);
            cacheManager.getCache(Settings.CACHE_NAME).putIfAbsent("API_EVALUACION_" + dto.getId(), dto);
            return dto;
        }).toList());

        response.setTotalPages(page.getTotalPages());
        return response;
    }


    @Override
    @Transactional
    public EvaluacionDTO update(Integer id, EvaluacionDTO dto) {
        if (dto.getEstado() != null && dto.getIdEtapa() != null && dto.getNombre() != null && dto.getTotalPunto() != null) {
            EvaluacionDTO response = evaluacionDao.findById(id).map(evaluacionDomain -> {
                evaluacionDomain.setNombre(dto.getNombre());
                evaluacionDomain.setEstado(dto.getEstado());
                evaluacionDomain.setIdEtapa(dto.getIdEtapa());
                evaluacionDomain.setTotalPunto(dto.getTotalPunto());
                dto.setId(evaluacionDomain.getId());
                cacheManager.getCache(Settings.CACHE_NAME).evictIfPresent("API_EVALUACION_" + id);
                return save(dto);
            }).orElse(null);

            if(response != null){
                cacheManager.getCache(Settings.CACHE_NAME).put("API_EVALUACION_" + response.getId(), response);
            }

            return response;


        }
        return null;
    }

    @Override
    @Transactional
    public Boolean delete(Integer id) {
        Boolean response = evaluacionDao.findById(id).map(evaluacionDomain -> {
            EvaluacionDTO dto = convertDomainToDto(evaluacionDomain);
            if (dto.getEstado()) {
                dto.setEstado(false);
                save(dto);
                if(dto != null){
                    cacheManager.getCache(Settings.CACHE_NAME).evictIfPresent("API_EVALUACION_" + id);
                }
                //se ocultan los detalles de la planilla a la cual esta asociada la evaluacion
                /*evaluacionDomain.getDetallesPlanillaNotas().forEach(detNotas -> {
                    detallePNService.delete(detNotas.getId());
                });*/
                detallePNDao.hiddenByIdEvaluacion(evaluacionDomain.getId());
                return true;
            } else {
                return false;
            }
        }).orElse(false);

        return response;
    }


    @Override
    @Transactional
    public Boolean saveFromTable(EvaluacionNuevaEnTablaDTO dto) {
        try {
            Integer idPlanillaNotas = dto.getIdPlanillaNotas();
            Integer idEtapa = dto.getIdEtapa();
            Integer idEvaluacion = dto.getId();

            List<Integer> alumnosIds = detallePNDao.getAllDistinctByIdPlanillaNota(idPlanillaNotas);


            //verificar etapa si es necesario crear
            if (idEtapa == null || (idEtapa <= 0)) {
                EtapaDTO etapaDTO = new EtapaDTO();
                etapaDTO.setDescripcion(dto.getDescripcionEtapa());
                etapaDTO.setEstado(true);

                EtapaServiceImpl etapaServ = new EtapaServiceImpl();
                EtapaDomain dom = etapaServ.convertDtoToDomain(etapaDTO);
                EtapaDomain response = etapaDao.save(dom);
                //if(response != null && response.getId() > 0) {
                    idEtapa = response.getId();
                    dto.setIdEtapa(response.getId());
                    //}
            }

            //verificar y crear evaluacion
            if(idEvaluacion == null || idEvaluacion <= 0){
                EvaluacionDTO dtoEval = new EvaluacionDTO();
                dtoEval.setIdEtapa(dto.getIdEtapa());
                dtoEval.setTotalPunto(dto.getTp());
                dtoEval.setNombre(dto.getDescripcionEvaluacion());
                dtoEval.setEstado(true);

                EvaluacionDTO response = save(dtoEval);
                idEvaluacion = response.getId();
            }

            //crear detalles
            final Integer IdEvaluacionFinal = idEvaluacion;
            alumnosIds.forEach(d -> {
                System.out.println("id etapa: "+ dto.getIdEtapa());
                Integer idListaAlumno = d;

                DetallePlanillaNotaDTO dtoDetalle = new DetallePlanillaNotaDTO();

                dtoDetalle.setIdEvaluacion(IdEvaluacionFinal);
                dtoDetalle.setPuntaje(0d);
                //dtoDetalle.setObservacion("");
                dtoDetalle.setIdListaAlumno(idListaAlumno);
                dtoDetalle.setIdPlanillaNota(dto.getIdPlanillaNotas());
                dtoDetalle.setEstado(true);
                try {
                    detallePNService.save(dtoDetalle);
                } catch (Exception e) {
                    System.out.println("Error al guardar el detalle");
                    //throw new RuntimeException(e);
                }
            });
            System.out.println("Imprimio los alumnos");

            return true;
        }catch (Exception e){

            System.out.println("ERROR DESCONOCIDO:" + e.getMessage());
            return false;
        }
    }


    @Override
    public EvaluacionDTO convertDomainToDto(EvaluacionDomain domain) {
        EvaluacionDTO dto = new EvaluacionDTO();
        dto.setId(domain.getId());
        dto.setEstado(domain.getEstado());
        dto.setNombre(domain.getNombre());
        dto.setTotalPunto(domain.getTotalPunto());
        dto.setEtapaDTO(etapaDao.findById(domain.getIdEtapa()).map(etapaDomain -> {
            EtapaDTO dtoEtapa = new EtapaDTO();
            dtoEtapa.setId(etapaDomain.getId());
            dtoEtapa.setDescripcion(etapaDomain.getDescripcion());
            dtoEtapa.setEstado(etapaDomain.getEstado());
            return dtoEtapa;
        }).orElse(null));
        dto.setIdEtapa(domain.getIdEtapa());

        return dto;
    }

    @Override
    public EvaluacionDomain convertDtoToDomain(EvaluacionDTO dto) {
        EvaluacionDomain domain = new EvaluacionDomain();
        domain.setId(dto.getId());
        domain.setEstado(dto.getEstado());
        domain.setNombre(dto.getNombre());
        domain.setTotalPunto(dto.getTotalPunto());
        domain.setIdEtapa(dto.getIdEtapa());

        return domain;
    }


}
