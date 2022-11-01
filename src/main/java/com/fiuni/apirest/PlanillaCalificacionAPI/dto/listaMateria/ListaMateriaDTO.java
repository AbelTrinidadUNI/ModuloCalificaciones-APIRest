package com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaMateria;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;

import java.util.List;


@XmlRootElement(name = "LISTA_MATERIAS")
public class ListaMateriaDTO extends BaseDTO {

    private Integer idClase;

    private Integer idMateria;

    private Integer idProfesor;

    private Boolean estado;



    @XmlElement
    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    @XmlElement
    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    @XmlElement
    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


}