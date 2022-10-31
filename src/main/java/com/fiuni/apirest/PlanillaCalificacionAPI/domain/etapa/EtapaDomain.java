package com.fiuni.apirest.PlanillaCalificacionAPI.domain.etapa;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.evaluacion.EvaluacionDomain;

import java.util.List;


@Entity
@Table(name = "ETAPAS")
public class EtapaDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ETAPA", nullable = false)
    private Integer id;

    @Column(name = "DESCRIPCION_ETAPA", nullable = false)
    private String descripcion;

    @Column(name = "ESTADO_ETAPA", nullable = false)
    private Boolean estado;

    @OneToMany(mappedBy = "etapa")
    private List<EvaluacionDomain> evaluaciones;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<EvaluacionDomain> getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(List<EvaluacionDomain> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }
}