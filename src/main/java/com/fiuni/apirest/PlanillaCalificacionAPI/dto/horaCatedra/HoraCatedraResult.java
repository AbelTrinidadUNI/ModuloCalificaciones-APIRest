package com.fiuni.apirest.PlanillaCalificacionAPI.dto.horaCatedra;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;

import java.util.List;

public class HoraCatedraResult extends BaseResult<HoraCatedraDTO> {
    public HoraCatedraResult() {

    }

    public HoraCatedraResult(List<HoraCatedraDTO> list) {
        this.setList(list);
    }

    public List<HoraCatedraDTO> getLista() {
        return this.getList();
    }
}

