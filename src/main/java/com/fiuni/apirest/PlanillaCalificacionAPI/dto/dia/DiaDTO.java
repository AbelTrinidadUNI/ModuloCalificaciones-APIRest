package com.fiuni.apirest.PlanillaCalificacionAPI.dto.dia;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;

import java.util.List;


@XmlRootElement(name = "DIAS")
public class DiaDTO extends BaseDTO {

    private String nombre;

    private Boolean estado;




    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}