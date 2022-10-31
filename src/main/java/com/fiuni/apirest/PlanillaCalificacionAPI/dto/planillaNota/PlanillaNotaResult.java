package com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;

import java.util.List;

public class PlanillaNotaResult extends BaseResult<PlanillaNotaDto> {
    public PlanillaNotaResult(){

    }
    public PlanillaNotaResult(List<PlanillaNotaDto> list){
        this.setList(list);
    }

    public List<PlanillaNotaDto> getLista(){
        return this.getList();
    }
}
