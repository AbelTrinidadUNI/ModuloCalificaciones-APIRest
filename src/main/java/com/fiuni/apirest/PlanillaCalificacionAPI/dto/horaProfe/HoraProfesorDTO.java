package com.fiuni.apirest.PlanillaCalificacionAPI.dto.horaProfe;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaMateria.ListaMateriaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.dia.DiaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.horaCatedra.HoraCatedraDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;


@XmlRootElement(name = "HORAS_PROFES")
public class HoraProfesorDTO extends BaseDTO {

    private Integer idHoraCatedra;

    private Integer idListaMateria;

    private Integer idDias;

    private Boolean estado;

    @XmlElement
    public Integer getIdHoraCatedra() {
        return idHoraCatedra;
    }

    public void setIdHoraCatedra(Integer idHoraCatedra) {
        this.idHoraCatedra = idHoraCatedra;
    }

    @XmlElement
    public Integer getIdListaMateria() {
        return idListaMateria;
    }

    public void setIdListaMateria(Integer idListaMateria) {
        this.idListaMateria = idListaMateria;
    }

    @XmlElement
    public Integer getIdDias() {
        return idDias;
    }

    public void setIdDias(Integer idDias) {
        this.idDias = idDias;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

}