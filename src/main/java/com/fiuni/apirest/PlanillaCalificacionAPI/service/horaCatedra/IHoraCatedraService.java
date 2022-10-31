package com.fiuni.apirest.PlanillaCalificacionAPI.service.horaCatedra;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.horaCatedra.HoraCatedraDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.horaCatedra.HoraCatedraResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface IHoraCatedraService extends IBaseService<HoraCatedraDTO, HoraCatedraResult> {

    public abstract HoraCatedraDTO update(Integer id, HoraCatedraDTO dto);

    public abstract Boolean delete(Integer id);
}
        
