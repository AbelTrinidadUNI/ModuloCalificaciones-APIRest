package com.fiuni.apirest.PlanillaCalificacionAPI.dto.informe;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;

import java.util.List;

public class InformeResult extends BaseResult<InformeDTO> {
    public InformeResult() {

    }

    public InformeResult(List<InformeDTO> list) {
        this.setList(list);
    }

    public List<InformeDTO> getLista() {
        return this.getList();
    }
}

