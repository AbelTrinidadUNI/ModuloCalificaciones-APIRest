package com.fiuni.apirest.PlanillaCalificacionAPI.dto.dia;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;

import java.util.List;

public class DiaResult extends BaseResult<DiaDTO> {
    public DiaResult() {

    }

    public DiaResult(List<DiaDTO> list) {
        this.setList(list);
    }

    public List<DiaDTO> getLista() {
        return this.getList();
    }
}

