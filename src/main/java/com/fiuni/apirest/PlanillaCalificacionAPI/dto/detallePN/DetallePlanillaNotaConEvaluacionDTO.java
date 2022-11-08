package com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionConEtapaDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DETALLES_PN")
public class DetallePlanillaNotaConEvaluacionDTO extends BaseDTO {
    private Integer idListaAlumno;
    private String nombreAlumno;
    private Double puntaje;
    private String observacion;
    private EvaluacionConEtapaDTO evaluacion;

    private Integer idPlanillaNota;
    private Boolean estadoDetalle;


    @XmlElement
    public Integer getIdListaAlumno() {
        return idListaAlumno;
    }

    public void setIdListaAlumno(Integer idListaAlumno) {
        this.idListaAlumno = idListaAlumno;
    }

    @XmlElement
    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
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
    public EvaluacionConEtapaDTO getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(EvaluacionConEtapaDTO evaluacion) {
        this.evaluacion = evaluacion;
    }

    @XmlElement
    public Boolean getEstadoDetalle() {
        return estadoDetalle;
    }

    public void setEstadoDetalle(Boolean estadoDetalle) {
        this.estadoDetalle = estadoDetalle;
    }

    @XmlElement
    public Integer getIdPlanillaNota() {
        return idPlanillaNota;
    }

    public void setIdPlanillaNota(Integer idPlanillaNota) {
        this.idPlanillaNota = idPlanillaNota;
    }
}