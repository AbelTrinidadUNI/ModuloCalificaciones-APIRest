package com.fiuni.apirest.PlanillaCalificacionAPI.service.dia;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.dia.DiaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.dia.DiaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface IDiaService extends IBaseService<DiaDTO, DiaResult> {

    public abstract DiaDTO update(Integer id, DiaDTO dto);

    public abstract Boolean delete(Integer id);
}
        
