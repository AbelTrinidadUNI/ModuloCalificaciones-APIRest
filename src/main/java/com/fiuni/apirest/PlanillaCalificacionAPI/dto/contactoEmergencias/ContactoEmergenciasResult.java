package com.fiuni.apirest.PlanillaCalificacionAPI.dto.contactoEmergencias;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.rol.RolDTO;

import java.util.List;

public class ContactoEmergenciasResult extends BaseResult<ContactoEmergenciasDTO> {
    public ContactoEmergenciasResult() {

    }

    public ContactoEmergenciasResult(List<ContactoEmergenciasDTO> list) {
        this.setList(list);
    }

    public List<ContactoEmergenciasDTO> getLista() {
        return this.getList();
    }
}