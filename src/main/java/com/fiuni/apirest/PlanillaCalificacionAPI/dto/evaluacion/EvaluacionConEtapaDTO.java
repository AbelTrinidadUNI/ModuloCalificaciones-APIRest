package com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "EVALUACIONES")
public class EvaluacionConEtapaDTO extends BaseDTO {

    private String nombreEvaluacion;

    private Double totalPunto;

    private Integer idEtapa;

    private String nombreEtapa;


    @XmlElement
    public String getNombreEvaluacion() {
        return nombreEvaluacion;
    }

    public void setNombreEvaluacion(String nombreEvaluacion) {
        this.nombreEvaluacion = nombreEvaluacion;
    }
    @XmlElement
    public Double getTotalPunto() {
        return totalPunto;
    }

    public void setTotalPunto(Double totalPunto) {
        this.totalPunto = totalPunto;
    }

    @XmlElement
    public Integer getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    @XmlElement
    public String getNombreEtapa() {
        return nombreEtapa;
    }

    public void setNombreEtapa(String nombreEtapa) {
        this.nombreEtapa = nombreEtapa;
    }
}
