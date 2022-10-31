package com.fiuni.apirest.PlanillaCalificacionAPI.service.detalleInforme;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detalleInforme.DetalleInformeDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detalleInforme.DetalleInformeResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface IDetalleInformeService extends IBaseService<DetalleInformeDTO, DetalleInformeResult> {

    public abstract DetalleInformeDTO update(Integer id, DetalleInformeDTO dto);

    public abstract Boolean delete(Integer id);
}
        
