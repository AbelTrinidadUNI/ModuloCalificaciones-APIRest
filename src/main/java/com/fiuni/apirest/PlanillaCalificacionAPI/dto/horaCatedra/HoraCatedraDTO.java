package com.fiuni.apirest.PlanillaCalificacionAPI.dto.horaCatedra;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.horaProfe.HoraProfesorDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;

import java.time.*;
import java.util.List;


@XmlRootElement(name = "HORAS_CATEDRAS")
public class HoraCatedraDTO extends BaseDTO {

    private LocalTime inicio;

    private LocalTime fin;

    private Boolean estado;


    @XmlElement
    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    @XmlElement
    public LocalTime getFin() {
        return fin;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


}