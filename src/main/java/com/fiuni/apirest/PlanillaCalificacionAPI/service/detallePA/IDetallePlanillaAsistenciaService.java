package com.fiuni.apirest.PlanillaCalificacionAPI.service.detallePA;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePA.DetallePlanillaAsistenciaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePA.DetallePlanillaAsistenciaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface IDetallePlanillaAsistenciaService extends IBaseService<DetallePlanillaAsistenciaDTO, DetallePlanillaAsistenciaResult> {

    public abstract DetallePlanillaAsistenciaDTO update(Integer id, DetallePlanillaAsistenciaDTO dto);

    public abstract Boolean delete(Integer id);
}
        
