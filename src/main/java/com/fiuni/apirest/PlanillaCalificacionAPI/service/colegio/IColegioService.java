package com.fiuni.apirest.PlanillaCalificacionAPI.service.colegio;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.colegio.ColegioDto;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.colegio.ColegioDto;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.colegio.ColegioResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface IColegioService extends IBaseService<ColegioDto, ColegioResult> {

    public abstract ColegioDto update(Integer id, ColegioDto dto);

    public abstract Boolean delete(Integer id);
}
        
