package com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaAsistencia;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;

import java.util.List;

public class PlanillaAsistenciaResult extends BaseResult<PlanillaAsistenciaDTO> {
    public PlanillaAsistenciaResult() {

    }

    public PlanillaAsistenciaResult(List<PlanillaAsistenciaDTO> list) {
        this.setList(list);
    }

    public List<PlanillaAsistenciaDTO> getLista() {
        return this.getList();
    }
}

