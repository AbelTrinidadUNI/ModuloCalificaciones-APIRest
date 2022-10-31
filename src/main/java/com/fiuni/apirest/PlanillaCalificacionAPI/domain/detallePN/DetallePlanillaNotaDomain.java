package com.fiuni.apirest.PlanillaCalificacionAPI.domain.detallePN;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.evaluacion.EvaluacionDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaAlumno.ListaAlumnoDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.planillaNota.PlanillaNotaDomain;


@Entity
@Table(name = "DETALLES_PN")
public class DetallePlanillaNotaDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DPN", nullable = false)
    private Integer id;

    @Column(name = "ID_EVAL")
    private Integer idEvaluacion;

    @Column(name = "ID_PN")
    private Integer idPlanillaNota;

    @Column(name = "ID_LA")
    private Integer idListaAlumno;

    @Column(name = "PUNTAJE_DPN", nullable = false)
    private Double puntaje;

    @Column(name = "OBSERVACION_DPN")
    private String observacion;

    @Column(name = "ESTADO_DPN", nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "ID_PN", insertable = false, updatable = false)
    private PlanillaNotaDomain planillaNota;

    @ManyToOne
    @JoinColumn(name = "ID_EVAL", insertable = false, updatable = false)
    private EvaluacionDomain evaluacion;

    @ManyToOne
    @JoinColumn(name = "ID_LA", insertable = false, updatable = false)
    private ListaAlumnoDomain listaAlumno;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Integer getIdPlanillaNota() {
        return idPlanillaNota;
    }

    public void setIdPlanillaNota(Integer idPlanillaNota) {
        this.idPlanillaNota = idPlanillaNota;
    }

    public Integer getIdListaAlumno() {
        return idListaAlumno;
    }

    public void setIdListaAlumno(Integer idListaAlumno) {
        this.idListaAlumno = idListaAlumno;
    }

    public Double getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Double puntaje) {
        this.puntaje = puntaje;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public PlanillaNotaDomain getPlanillaNota() {
        return planillaNota;
    }

    public void setPlanillaNota(PlanillaNotaDomain planillaNota) {
        this.planillaNota = planillaNota;
    }

    public EvaluacionDomain getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(EvaluacionDomain evaluacion) {
        this.evaluacion = evaluacion;
    }

    public ListaAlumnoDomain getListaAlumno() {
        return listaAlumno;
    }

    public void setListaAlumno(ListaAlumnoDomain listaAlumno) {
        this.listaAlumno = listaAlumno;
    }
}
