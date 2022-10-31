package com.fiuni.apirest.PlanillaCalificacionAPI.dto.planClase;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;

import java.util.List;

public class PlanClaseResult extends BaseResult<PlanClaseDTO> {
    public PlanClaseResult() {

    }

    public PlanClaseResult(List<PlanClaseDTO> list) {
        this.setList(list);
    }

    public List<PlanClaseDTO> getLista() {
        return this.getList();
    }
}

