package com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePA;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;

import java.util.List;

public class DetallePlanillaAsistenciaResult extends BaseResult<DetallePlanillaAsistenciaDTO> {
    public DetallePlanillaAsistenciaResult() {

    }

    public DetallePlanillaAsistenciaResult(List<DetallePlanillaAsistenciaDTO> list) {
        this.setList(list);
    }

    public List<DetallePlanillaAsistenciaDTO> getLista() {
        return this.getList();
    }
}

