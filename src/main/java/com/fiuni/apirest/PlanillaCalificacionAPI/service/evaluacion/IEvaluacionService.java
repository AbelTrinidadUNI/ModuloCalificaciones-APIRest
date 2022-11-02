package com.fiuni.apirest.PlanillaCalificacionAPI.service.evaluacion;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;
import org.springframework.http.ResponseEntity;

public interface IEvaluacionService extends IBaseService<EvaluacionDTO, EvaluacionResult> {

    public abstract ResponseEntity<EvaluacionDTO> update(Integer id, EvaluacionDTO dto);

    public abstract ResponseEntity<Boolean> delete(Integer id);
}
