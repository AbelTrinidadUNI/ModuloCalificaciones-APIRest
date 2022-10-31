package com.fiuni.apirest.PlanillaCalificacionAPI.service.planillaNota;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaDto;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaDto;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface IPlanillaNotaService extends IBaseService<PlanillaNotaDto, PlanillaNotaResult> {

    public abstract PlanillaNotaDto update(Integer id, PlanillaNotaDto dto);

    public abstract Boolean delete(Integer id);
}
        
