package com.fiuni.apirest.PlanillaCalificacionAPI.service.clase;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.clase.ClaseDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.clase.ClaseResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface IClaseService extends IBaseService<ClaseDTO, ClaseResult> {

    public abstract ClaseDTO update(Integer id, ClaseDTO dto);

    public abstract Boolean delete(Integer id);
}
        
