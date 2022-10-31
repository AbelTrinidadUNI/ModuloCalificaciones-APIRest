package com.fiuni.apirest.PlanillaCalificacionAPI.domain.detalleInforme;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.informe.InformeDomain;

@Entity
@Table(name = "DETALLES_INFORMES")
public class DetalleInformeDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DI", nullable = false)
    private Integer id;

    @Column(name = "ID_INF")
    private Integer idInforme;

    @Column(name = "DESCRIPCION_DI", nullable = false)
    private String descripcion;

    @Column(name = "ESTADO_DI", nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "ID_INF", insertable = false, updatable = false)
    private InformeDomain informe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(Integer idInforme) {
        this.idInforme = idInforme;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public InformeDomain getInforme() {
        return informe;
    }

    public void setInforme(InformeDomain informe) {
        this.informe = informe;
    }
}