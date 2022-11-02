package com.fiuni.apirest.PlanillaCalificacionAPI.service.detallePN;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;
import org.springframework.http.ResponseEntity;

import java.util.stream.DoubleStream;

public interface IDetallePlanillaNotaService extends IBaseService<DetallePlanillaNotaDTO, DetallePlanillaNotaResult> {

    public abstract ResponseEntity<DetallePlanillaNotaDTO> update(Integer id, DetallePlanillaNotaDTO dto);



}
        
