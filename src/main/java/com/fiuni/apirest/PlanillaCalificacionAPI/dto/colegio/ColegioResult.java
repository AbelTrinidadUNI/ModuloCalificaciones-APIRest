package com.fiuni.apirest.PlanillaCalificacionAPI.dto.colegio;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.materia.MateriaDTO;

import java.util.List;

public class ColegioResult extends BaseResult<ColegioDto> {
    public ColegioResult() {

    }

    public ColegioResult(List<ColegioDto> list) {
        this.setList(list);
    }

    public List<ColegioDto> getLista() {
        return this.getList();
    }
}
