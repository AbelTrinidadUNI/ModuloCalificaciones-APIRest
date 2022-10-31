package com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;

import java.util.List;

public class EvaluacionResult extends BaseResult<EvaluacionDTO> {
    public EvaluacionResult(){

    }
    public EvaluacionResult(List<EvaluacionDTO> list){
        this.setList(list);
    }

    public List<EvaluacionDTO> getLista(){
        return this.getList();
    }
}
