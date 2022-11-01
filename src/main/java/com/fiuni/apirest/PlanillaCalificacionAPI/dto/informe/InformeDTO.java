package com.fiuni.apirest.PlanillaCalificacionAPI.dto.informe;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;

import java.time.*;
import java.util.List;

@XmlRootElement(name = "INFORMES")
public class InformeDTO extends BaseDTO {

    private Integer idProfesor;

    private LocalDateTime fechaCreacion;

    private String titulo;

    private Boolean estado;

    @XmlElement
    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    @XmlElement
    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @XmlElement
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


}