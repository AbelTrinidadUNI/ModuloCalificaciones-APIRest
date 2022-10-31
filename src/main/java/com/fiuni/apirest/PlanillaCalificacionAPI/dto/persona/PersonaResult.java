package com.fiuni.apirest.PlanillaCalificacionAPI.dto.persona;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;

import java.util.List;

public class PersonaResult extends BaseResult<PersonaDTO> {
    public PersonaResult() {

    }

    public PersonaResult(List<PersonaDTO> list) {
        this.setList(list);
    }

    public List<PersonaDTO> getLista() {
        return this.getList();
    }
}
