package com.fiuni.apirest.PlanillaCalificacionAPI.service.detallePN;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.detallePN.IDetallePNDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaConEvaluacionDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionConEtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.etapa.utils.Settings;
import com.library.domainLibrary.domain.detallePN.DetallePlanillaNotaDomain;
import com.library.domainLibrary.domain.etapa.EtapaDomain;
import com.library.domainLibrary.domain.evaluacion.EvaluacionDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DetallePlanillaNotaServiceImpl extends BaseServiceImpl<DetallePlanillaNotaDTO, DetallePlanillaNotaDomain, DetallePlanillaNotaResult> implements IDetallePlanillaNotaService {

    @Autowired
    private IDetallePNDao detalle;

    @Autowired
    private CacheManager cacheManager;

    private DetallePlanillaNotaDomain detallePlanillaNotaDomain;

    @Override
    @Transactional
    public DetallePlanillaNotaDTO save(DetallePlanillaNotaDTO dto) {
        dto.setEstado(dto.getEstado() == null ? true : dto.getEstado());
        DetallePlanillaNotaDTO response = convertDomainToDto(detalle.save(convertDtoToDomain(dto)));

        if (dto.getId() == null) {
            cacheManager.getCache(Settings.CACHE_NAME).put("API_DETALLES_PN_" + response.getId(), response);
        }
        return response;
    }

    @Override
    @Transactional
    @Cacheable(value = Settings.CACHE_NAME, key = "'API_DETALLES_PN_' + #id")
    public DetallePlanillaNotaDTO getById(Integer id) {
        DetallePlanillaNotaDTO response = detalle.findById(id).map(d -> convertDomainToDto(d)).orElse(null);
        return response;
    }

    @Override
    @Transactional
    public DetallePlanillaNotaResult getAll(Pageable pageable) {
        /*DetallePlanillaNotaResult result = new DetallePlanillaNotaResult(detalle.findAll(pageable).map(d -> {
            DetallePlanillaNotaDTO dto = convertDomainToDto(d);
            cacheManager.getCache(Settings.CACHE_NAME).putIfAbsent("API_DETALLES_PN_" + dto.getId(), dto);
            return dto;
        }).toList());
        */
        Page<DetallePlanillaNotaDomain> page = detalle.getByEstadoTrue(pageable);
        DetallePlanillaNotaResult response = new DetallePlanillaNotaResult(page.map(d -> {
            DetallePlanillaNotaDTO dto = convertDomainToDto(d);
            cacheManager.getCache(Settings.CACHE_NAME).putIfAbsent("API_DETALLES_PN_" + dto.getId(), dto);
            return dto;
        }).toList());

        response.setTotalPages(page.getTotalPages());

        return response;
    }

    @Override
    @Transactional
    public DetallePlanillaNotaDTO update(Integer id, DetallePlanillaNotaDTO dto) {
        if (dto != null && dto.getEstado() != null && dto.getObservacion() != null && dto.getPuntaje() != null
                && dto.getIdEvaluacion() != null && dto.getIdEvaluacion() > 0
                && dto.getIdPlanillaNota() != null && dto.getIdPlanillaNota() > 0
                && dto.getIdListaAlumno() != null && dto.getIdListaAlumno() > 0) {
            DetallePlanillaNotaDTO result = detalle.findById(id).map(d -> {

                d.setEstado(dto.getEstado());
                d.setIdPlanillaNota(dto.getIdPlanillaNota());
                d.setIdEvaluacion(dto.getIdEvaluacion());
                d.setIdListaAlumno(dto.getIdListaAlumno());
                d.setObservacion(dto.getObservacion());
                d.setPuntaje(dto.getPuntaje());

                dto.setId(d.getId());

                cacheManager.getCache(Settings.CACHE_NAME).evictIfPresent("API_DETALLES_PN_" + id);

                return save(dto);
            }).orElse(null);

            if(result != null){
                cacheManager.getCache(Settings.CACHE_NAME).put("API_DETALLES_PN_" + result.getId(), result);
            }

            return result;
        }
        return null;

    }

    @Override
    public Boolean delete(Integer id) {
        Boolean response = detalle.delete(id);

        if(response != null && response){
            cacheManager.getCache(Settings.CACHE_NAME).evictIfPresent("API_DETALLES_PN_" + id);
        }
        return response;

    }


    @Override
    public DetallePlanillaNotaDTO convertDomainToDto(DetallePlanillaNotaDomain domain) {
        DetallePlanillaNotaDTO dto = new DetallePlanillaNotaDTO();
        dto.setId(domain.getId());
        dto.setEstado(domain.getEstado());
        dto.setObservacion(domain.getObservacion());
        dto.setIdPlanillaNota(domain.getIdPlanillaNota());
        dto.setIdEvaluacion(domain.getIdEvaluacion());
        dto.setIdListaAlumno(domain.getIdListaAlumno());
        dto.setPuntaje(domain.getPuntaje());

        return dto;
    }

    @Override
    public DetallePlanillaNotaDomain convertDtoToDomain(DetallePlanillaNotaDTO dto) {
        DetallePlanillaNotaDomain domain = new DetallePlanillaNotaDomain();
        domain.setId(dto.getId());
        domain.setEstado(dto.getEstado());
        domain.setObservacion(dto.getObservacion());
        domain.setIdPlanillaNota(dto.getIdPlanillaNota());
        domain.setIdEvaluacion(dto.getIdEvaluacion());
        domain.setIdListaAlumno(dto.getIdListaAlumno());
        domain.setPuntaje(dto.getPuntaje());

        return domain;
    }


    @Override
    public DetallePlanillaNotaConEvaluacionDTO convertDomainToDto2(DetallePlanillaNotaDomain domain) {

        DetallePlanillaNotaConEvaluacionDTO dto = new DetallePlanillaNotaConEvaluacionDTO();

        dto.setId(domain.getId());
        dto.setObservacion(domain.getObservacion());
        dto.setIdListaAlumno(domain.getIdListaAlumno());
        dto.setNombreAlumno(domain.getListaAlumno().getAlumno().getNombre());
        dto.setPuntaje(domain.getPuntaje());

        EvaluacionConEtapaDTO evDTO = new EvaluacionConEtapaDTO();
        evDTO.setId(domain.getIdEvaluacion());
        evDTO.setIdEtapa(domain.getEvaluacion().getIdEtapa());
        evDTO.setNombreEtapa(domain.getEvaluacion().getEtapa().getDescripcion());
        evDTO.setNombreEvaluacion(domain.getEvaluacion().getNombre());
        evDTO.setTotalPunto(domain.getEvaluacion().getTotalPunto());


        dto.setEvaluacion(evDTO);
        return dto;
    }

    //solo convierte la tabla a la de detalles
    @Override
    public DetallePlanillaNotaDomain convertDtoToDomain2(DetallePlanillaNotaConEvaluacionDTO dto) {
        DetallePlanillaNotaDomain domain = new DetallePlanillaNotaDomain();
        domain.setId(dto.getId());
        domain.setIdListaAlumno(dto.getIdListaAlumno());
        domain.setEstado(dto.getEstadoDetalle());
        domain.setPuntaje(dto.getPuntaje());
        domain.setIdEvaluacion(dto.getEvaluacion().getId());
        domain.setIdPlanillaNota(dto.getIdPlanillaNota());
        domain.setObservacion(dto.getObservacion());

        return domain;
    }

    public EtapaDomain convertDtoToDomainEtapas(DetallePlanillaNotaConEvaluacionDTO dto) {
        EtapaDomain domain = new EtapaDomain();
        domain.setId(dto.getId());
        domain.setDescripcion(dto.getEvaluacion().getNombreEtapa());
        return domain;
    }

    public EvaluacionDomain convertDtoToDomainEvaluacion(DetallePlanillaNotaConEvaluacionDTO dto) {
        EvaluacionDomain domain = new EvaluacionDomain();
        domain.setId(dto.getId());
        domain.setTotalPunto(dto.getEvaluacion().getTotalPunto());
        domain.setNombre(dto.getEvaluacion().getNombreEvaluacion());
        domain.setIdEtapa(dto.getEvaluacion().getIdEtapa());

        return domain;
    }
}
