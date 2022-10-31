package com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;

import java.util.List;

public class EtapaResult extends BaseResult<EtapaDTO> {
    public EtapaResult(){

    }
    public EtapaResult(List<EtapaDTO> list){
        this.setList(list);
    }

    public List<EtapaDTO> getLista(){
        return this.getList();
    }
}
