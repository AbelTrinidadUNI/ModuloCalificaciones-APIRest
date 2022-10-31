package com.fiuni.apirest.PlanillaCalificacionAPI.service.detallePN;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface IDetallePlanillaNotaService extends IBaseService<DetallePlanillaNotaDTO, DetallePlanillaNotaResult> {

    public abstract DetallePlanillaNotaDTO update(Integer id, DetallePlanillaNotaDTO dto);

    public abstract Boolean delete(Integer id);
}
        
