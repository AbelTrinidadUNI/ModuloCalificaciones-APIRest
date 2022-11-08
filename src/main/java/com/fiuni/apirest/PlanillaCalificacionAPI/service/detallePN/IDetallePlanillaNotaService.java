package com.fiuni.apirest.PlanillaCalificacionAPI.service.detallePN;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.*;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;
import com.library.domainLibrary.domain.detallePN.DetallePlanillaNotaDomain;
import org.springframework.http.ResponseEntity;

import java.util.stream.DoubleStream;

public interface IDetallePlanillaNotaService extends IBaseService<DetallePlanillaNotaDTO, DetallePlanillaNotaResult> {

    public abstract ResponseEntity<DetallePlanillaNotaDTO> update(Integer id, DetallePlanillaNotaDTO dto);

    public abstract ResponseEntity<Boolean> delete(Integer id);

    public abstract DetallePlanillaNotaConEvaluacionDTO convertDomainToDto2(DetallePlanillaNotaDomain domain);
    public abstract DetallePlanillaNotaDomain convertDtoToDomain2(DetallePlanillaNotaConEvaluacionDTO dto);

}
        
