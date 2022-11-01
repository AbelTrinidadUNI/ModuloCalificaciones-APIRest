package com.fiuni.apirest.PlanillaCalificacionAPI.service.detallePN;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.detallePN.IDetallePNDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.library.domainLibrary.domain.detallePN.DetallePlanillaNotaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;


public class DetallePlanillaNotaServiceImpl extends BaseServiceImpl<DetallePlanillaNotaDTO, DetallePlanillaNotaDomain, DetallePlanillaNotaResult> implements IDetallePlanillaNotaService {

    @Autowired
    private IDetallePNDao detalle;

    @Override
    public DetallePlanillaNotaDTO save(DetallePlanillaNotaDTO dto) {
        return convertDomainToDto(detalle.save(convertDtoToDomain(dto)));
    }

    @Override
    public DetallePlanillaNotaDTO getById(Integer id) {
        return detalle.findById(id).map(d -> convertDomainToDto(d)).orElse(null);
    }

    @Override
    public DetallePlanillaNotaResult getAll(Pageable pageable) {
        DetallePlanillaNotaResult detalles = new DetallePlanillaNotaResult(detalle.findAll(pageable).map(d -> convertDomainToDto(d)).toList());
        return detalles;
    }

    @Override
    public DetallePlanillaNotaDTO update(Integer id, DetallePlanillaNotaDTO dto) {
        if (dto.getEstado() != null && dto.getObservacion() != null && dto.getPuntaje() != null) {
            return detalle.findById(id).map(d -> {

                d.setEstado(dto.getEstado());
                d.setIdPlanillaNota(dto.getIdPlanillaNota());
                d.setIdEvaluacion(dto.getIdEvaluacion());
                d.setIdListaAlumno(dto.getIdListaAlumno());
                d.setObservacion(dto.getObservacion());
                d.setPuntaje(dto.getPuntaje());

                dto.setId(d.getId());
                return save(dto);
            }).orElse(null) != null ? dto : null;
        }
        return null;
    }



    @Override
    protected DetallePlanillaNotaDTO convertDomainToDto(DetallePlanillaNotaDomain domain) {
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
    protected DetallePlanillaNotaDomain convertDtoToDomain(DetallePlanillaNotaDTO dto) {
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
}
