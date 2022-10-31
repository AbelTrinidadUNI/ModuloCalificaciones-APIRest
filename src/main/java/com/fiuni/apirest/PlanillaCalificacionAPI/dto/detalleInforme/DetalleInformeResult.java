package com.fiuni.apirest.PlanillaCalificacionAPI.dto.detalleInforme;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;

import java.util.List;

public class DetalleInformeResult extends BaseResult<DetalleInformeDTO> {
    public DetalleInformeResult() {

    }

    public DetalleInformeResult(List<DetalleInformeDTO> list) {
        this.setList(list);
    }

    public List<DetalleInformeDTO> getLista() {
        return this.getList();
    }
}

