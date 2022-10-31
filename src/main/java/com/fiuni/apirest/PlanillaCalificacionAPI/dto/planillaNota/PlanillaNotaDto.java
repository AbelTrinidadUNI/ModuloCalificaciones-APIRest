package com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.detallePN.DetallePlanillaNotaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaMateria.ListaMateriaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;

import java.util.List;

@XmlRootElement(name = "PLANILLA_ASISTENCIAS")
public class PlanillaNotaDto extends BaseDTO {

    private Integer idListaMateria;

    private Boolean estado;



    @XmlElement
    public Integer getIdListaMateria() {
        return idListaMateria;
    }

    public void setIdListaMateria(Integer idListaMateria) {
        this.idListaMateria = idListaMateria;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
