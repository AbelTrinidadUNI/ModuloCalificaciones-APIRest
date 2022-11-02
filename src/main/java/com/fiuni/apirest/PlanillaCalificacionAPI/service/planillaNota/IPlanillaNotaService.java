package com.fiuni.apirest.PlanillaCalificacionAPI.service.planillaNota;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaDto;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaDto;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;
import org.springframework.http.ResponseEntity;

public interface IPlanillaNotaService extends IBaseService<PlanillaNotaDto, PlanillaNotaResult> {

    public abstract ResponseEntity<PlanillaNotaDto> update(Integer id, PlanillaNotaDto dto);

    public abstract ResponseEntity<Boolean> delete(Integer id);
}
        
