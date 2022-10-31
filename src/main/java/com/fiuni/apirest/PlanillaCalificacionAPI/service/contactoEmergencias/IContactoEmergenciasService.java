package com.fiuni.apirest.PlanillaCalificacionAPI.service.contactoEmergencias;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.contactoEmergencias.ContactoEmergenciasDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.contactoEmergencias.ContactoEmergenciasResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface IContactoEmergenciasService extends IBaseService<ContactoEmergenciasDTO, ContactoEmergenciasResult> {

    public abstract ContactoEmergenciasDTO update(Integer id, ContactoEmergenciasDTO dto);

    public abstract Boolean delete(Integer id);
}
        
