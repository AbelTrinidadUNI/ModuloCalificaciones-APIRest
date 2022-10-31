package com.fiuni.apirest.PlanillaCalificacionAPI.dto.rol;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.persona.PersonaDTO;

import java.util.List;

public class RolResult extends BaseResult<RolDTO> {
    public RolResult() {

    }

    public RolResult(List<RolDTO> list) {
        this.setList(list);
    }

    public List<RolDTO> getLista() {
        return this.getList();
    }
}
