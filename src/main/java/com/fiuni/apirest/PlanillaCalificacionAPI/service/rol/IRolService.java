package com.fiuni.apirest.PlanillaCalificacionAPI.service.rol;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.rol.RolDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.rol.RolResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface IRolService extends IBaseService<RolDTO, RolResult> {

    public abstract RolDTO update(Integer id, RolDTO dto);

    public abstract Boolean delete(Integer id);
}
        
