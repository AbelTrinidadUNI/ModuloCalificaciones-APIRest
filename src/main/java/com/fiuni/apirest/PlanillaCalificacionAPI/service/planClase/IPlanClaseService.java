package com.fiuni.apirest.PlanillaCalificacionAPI.service.planClase;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planClase.PlanClaseDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planClase.PlanClaseResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface IPlanClaseService extends IBaseService<PlanClaseDTO, PlanClaseResult> {

    public abstract PlanClaseDTO update(Integer id, PlanClaseDTO dto);

    public abstract Boolean delete(Integer id);
}
        
