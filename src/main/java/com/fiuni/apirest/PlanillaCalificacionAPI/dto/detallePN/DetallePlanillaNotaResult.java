package com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionDTO;

import java.util.List;

public class DetallePlanillaNotaResult extends BaseResult<DetallePlanillaNotaDTO> {
    public DetallePlanillaNotaResult(){

    }
    public DetallePlanillaNotaResult(List<DetallePlanillaNotaDTO> list){
        this.setList(list);
    }

    public List<DetallePlanillaNotaDTO> getLista(){
        return this.getList();
    }
}
