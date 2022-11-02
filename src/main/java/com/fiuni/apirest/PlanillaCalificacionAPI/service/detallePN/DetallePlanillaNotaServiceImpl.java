package com.fiuni.apirest.PlanillaCalificacionAPI.service.detallePN;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.detallePN.IDetallePNDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.library.domainLibrary.domain.detallePN.DetallePlanillaNotaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;


public class DetallePlanillaNotaServiceImpl extends BaseServiceImpl<DetallePlanillaNotaDTO, DetallePlanillaNotaDomain, DetallePlanillaNotaResult> implements IDetallePlanillaNotaService {

    @Autowired
    private IDetallePNDao detalle;

    @Override
    @Transactional
    public ResponseEntity<DetallePlanillaNotaDTO> save(DetallePlanillaNotaDTO dto) {
        dto.setEstado(dto.getEstado() == null ? true : dto.getEstado());
        DetallePlanillaNotaDTO response = convertDomainToDto(detalle.save(convertDtoToDomain(dto)));
        return response != null ? new ResponseEntity<DetallePlanillaNotaDTO>(response, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    @Transactional
    public ResponseEntity<DetallePlanillaNotaDTO> getById(Integer id) {
        DetallePlanillaNotaDTO response = detalle.findById(id).map(d -> convertDomainToDto(d)).orElse(null);
        return response != null ? new ResponseEntity(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public ResponseEntity<DetallePlanillaNotaResult> getAll(Pageable pageable) {
        DetallePlanillaNotaResult result = new DetallePlanillaNotaResult(detalle.findAll(pageable).map(d -> convertDomainToDto(d)).toList());
        return result != null ? new ResponseEntity<DetallePlanillaNotaResult>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public ResponseEntity<DetallePlanillaNotaDTO> update(Integer id, DetallePlanillaNotaDTO dto) {
        if (dto.getEstado() != null && dto.getObservacion() != null && dto.getPuntaje() != null
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
                return save(dto);
            }).orElse(null).getBody();
            return result != null ? new ResponseEntity<DetallePlanillaNotaDTO>(result, HttpStatus.NO_CONTENT) :
                    new ResponseEntity<>(result, HttpStatus.CONFLICT);

        }
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);

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
