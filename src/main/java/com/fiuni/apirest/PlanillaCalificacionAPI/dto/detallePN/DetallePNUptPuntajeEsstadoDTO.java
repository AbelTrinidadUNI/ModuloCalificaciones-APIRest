package com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "DETALLES_PN")
public class DetallePNUptPuntajeEsstadoDTO extends BaseDTO {
    private Double puntaje = 0d;
    private Boolean estado = true;

    @XmlElement
    public Double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
