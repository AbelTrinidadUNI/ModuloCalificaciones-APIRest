package com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "EVALUACIONES")
public class EvaluacionNuevaEnTablaDTO extends BaseDTO {
    /*
    * {idEtapa: 0, descripcionEtapa: '', puntaje: 0, descripcionEvaluacion: '', idPlanillaNota: 1}
    * */

    private Integer idEtapa;
    private String descripcionEtapa;
    private Double tp;
    private String descripcionEvaluacion;
    private Integer idPlanillaNotas;

    @XmlElement
    public Integer getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    @XmlElement
    public String getDescripcionEtapa() {
        return descripcionEtapa;
    }

    public void setDescripcionEtapa(String descripcionEtapa) {
        this.descripcionEtapa = descripcionEtapa;
    }

    @XmlElement
    public Double getTp() {
        return tp;
    }

    public void setTp(Double tp) {
        this.tp = tp;
    }

    @XmlElement
    public String getDescripcionEvaluacion() {
        return descripcionEvaluacion;
    }

    public void setDescripcionEvaluacion(String descripcionEvaluacion) {
        this.descripcionEvaluacion = descripcionEvaluacion;
    }

    @XmlElement
    public Integer getIdPlanillaNotas() {
        return idPlanillaNotas;
    }

    public void setIdPlanillaNotas(Integer idPlanillaNotas) {
        this.idPlanillaNotas = idPlanillaNotas;
    }
}
