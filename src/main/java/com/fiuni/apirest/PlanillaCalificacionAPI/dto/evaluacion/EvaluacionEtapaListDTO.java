package com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "EVALUACIONES")
public class EvaluacionEtapaListDTO extends BaseDTO {
    private String nombre;

    private Double totalPunto;

    private Boolean estado;

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public Double getTotalPunto() {
        return totalPunto;
    }

    public void setTotalPunto(Double totalPunto) {
        this.totalPunto = totalPunto;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
