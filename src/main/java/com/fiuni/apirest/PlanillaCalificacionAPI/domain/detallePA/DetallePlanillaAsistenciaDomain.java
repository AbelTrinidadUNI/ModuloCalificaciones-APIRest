package com.fiuni.apirest.PlanillaCalificacionAPI.domain.detallePA;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaAlumno.ListaAlumnoDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.planillaAsistencia.PlanillaAsistenciaDomain;


@Entity
@Table(name = "DETALLES_PA")
public class DetallePlanillaAsistenciaDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DPA", nullable = false)
    private Integer id;

    @Column(name = "ID_PA")
    private Integer idPlanillaAsistencia;

    @Column(name = "ID_LA")
    private Integer idListaAlumno;

    @Column(name = "ASISTENCIA_DPA", nullable = false)
    private Boolean asistencia;

    @Column(name = "JUSTIFICATIVO_DPA")
    private String justificativo;

    @Column(name = "ESTADO_DPA", nullable = false)
    private Boolean estado;


    @ManyToOne
    @JoinColumn(name = "ID_PA", insertable = false, updatable = false)
    private PlanillaAsistenciaDomain planillaAsistencia;

    @ManyToOne
    @JoinColumn(name = "ID_LA", insertable = false, updatable = false)
    private ListaAlumnoDomain listaAlumno;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPlanillaAsistencia() {
        return idPlanillaAsistencia;
    }

    public void setIdPlanillaAsistencia(Integer idPlanillaAsistencia) {
        this.idPlanillaAsistencia = idPlanillaAsistencia;
    }

    public Integer getIdListaAlumno() {
        return idListaAlumno;
    }

    public void setIdListaAlumno(Integer idListaAlumno) {
        this.idListaAlumno = idListaAlumno;
    }

    public Boolean getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(Boolean asistencia) {
        this.asistencia = asistencia;
    }

    public String getJustificativo() {
        return justificativo;
    }

    public void setJustificativo(String justificativo) {
        this.justificativo = justificativo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public PlanillaAsistenciaDomain getPlanillaAsistencia() {
        return planillaAsistencia;
    }

    public void setPlanillaAsistencia(PlanillaAsistenciaDomain planillaAsistencia) {
        this.planillaAsistencia = planillaAsistencia;
    }

    public ListaAlumnoDomain getListaAlumno() {
        return listaAlumno;
    }

    public void setListaAlumno(ListaAlumnoDomain listaAlumno) {
        this.listaAlumno = listaAlumno;
    }
}