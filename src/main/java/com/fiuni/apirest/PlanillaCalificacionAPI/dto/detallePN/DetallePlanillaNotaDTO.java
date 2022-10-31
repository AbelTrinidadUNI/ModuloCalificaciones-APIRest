package com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;


@XmlRootElement(name = "DETALLES_PN")
public class DetallePlanillaNotaDTO extends BaseDTO {


    private Integer idEvaluacion;

    private Integer idPlanillaNota;

    private Integer idListaAlumno;

    private Double puntaje;

    private String observacion;

    private Boolean estado;


    @XmlElement
    public Integer getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    @XmlElement
    public Integer getIdPlanillaNota() {
        return idPlanillaNota;
    }

    public void setIdPlanillaNota(Integer idPlanillaNota) {
        this.idPlanillaNota = idPlanillaNota;
    }

    @XmlElement
    public Integer getIdListaAlumno() {
        return idListaAlumno;
    }

    public void setIdListaAlumno(Integer idListaAlumno) {
        this.idListaAlumno = idListaAlumno;
    }

    @XmlElement
    public Double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    @XmlElement
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }


}
