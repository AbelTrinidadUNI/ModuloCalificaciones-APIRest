package com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement(name = "ETAPAS")
public class EtapaDTO extends BaseDTO {

    private static final long serialVersionUID = 1L;

    private String descripcion;

    private Boolean estado;

    @XmlElement
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
