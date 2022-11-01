package com.fiuni.apirest.PlanillaCalificacionAPI.dto.detalleInforme;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;

@XmlRootElement(name = "DETALLES_INFORMES")
public class DetalleInformeDTO extends BaseDTO {


    private Integer idInforme;

    private String descripcion;

    private Boolean estado;


    @XmlElement
    public Integer getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(Integer idInforme) {
        this.idInforme = idInforme;
    }

    @XmlElement
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


}