package com.fiuni.apirest.PlanillaCalificacionAPI.dto.clase;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.ciclo.CicloDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.colegio.ColegioDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaAlumno.ListaAlumnoDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaMateria.ListaMateriaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "CLASES")
public class ClaseDTO extends BaseDTO {

    private Integer idColegio;

    private Integer idCiclo;

    private String nombre;

    private String turno;

    private Integer anho;

    private Boolean estado;


    @XmlElement
    public Integer getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(Integer idColegio) {
        this.idColegio = idColegio;
    }

    @XmlElement
    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @XmlElement
    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}
