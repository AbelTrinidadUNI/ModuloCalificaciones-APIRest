package com.fiuni.apirest.PlanillaCalificacionAPI.service.planillaAsistencia;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaAsistencia.PlanillaAsistenciaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaAsistencia.PlanillaAsistenciaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface IPlanillaAsistenciaService extends IBaseService<PlanillaAsistenciaDTO, PlanillaAsistenciaResult> {

    public abstract PlanillaAsistenciaDTO update(Integer id, PlanillaAsistenciaDTO dto);

    public abstract Boolean delete(Integer id);
}
        
