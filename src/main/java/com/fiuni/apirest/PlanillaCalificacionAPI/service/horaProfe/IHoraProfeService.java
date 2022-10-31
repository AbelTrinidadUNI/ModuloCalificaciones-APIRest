package com.fiuni.apirest.PlanillaCalificacionAPI.service.horaProfe;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.horaProfe.HoraProfesorDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.horaProfe.HoraProfesorDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.horaProfe.HoraProfesorResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface IHoraProfeService extends IBaseService<HoraProfesorDTO, HoraProfesorResult> {

    public abstract HoraProfesorDTO update(Integer id, HoraProfesorDTO dto);

    public abstract Boolean delete(Integer id);
}
        
