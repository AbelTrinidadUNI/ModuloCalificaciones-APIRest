package com.fiuni.apirest.PlanillaCalificacionAPI.service.ciclo;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.ciclo.CicloDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.ciclo.CicloResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface ICicloService extends IBaseService<CicloDTO, CicloResult> {

    public abstract CicloDTO update(Integer id, CicloDTO dto);

    public abstract Boolean delete(Integer id);
}
        
