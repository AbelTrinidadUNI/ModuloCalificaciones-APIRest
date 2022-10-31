package com.fiuni.apirest.PlanillaCalificacionAPI.dto.horaProfe;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;

import java.util.List;

public class HoraProfesorResult extends BaseResult<HoraProfesorDTO> {
    public HoraProfesorResult() {

    }

    public HoraProfesorResult(List<HoraProfesorDTO> list) {
        this.setList(list);
    }

    public List<HoraProfesorDTO> getLista() {
        return this.getList();
    }
}

