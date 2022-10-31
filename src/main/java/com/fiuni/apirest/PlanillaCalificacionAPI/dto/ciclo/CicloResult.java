package com.fiuni.apirest.PlanillaCalificacionAPI.dto.ciclo;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;

import java.util.List;

public class CicloResult extends BaseResult<CicloDTO> {
    public CicloResult() {

    }

    public CicloResult(List<CicloDTO> list) {
        this.setList(list);
    }

    public List<CicloDTO> getLista() {
        return this.getList();
    }
}
