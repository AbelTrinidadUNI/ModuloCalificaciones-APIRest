package com.fiuni.apirest.PlanillaCalificacionAPI.domain.evaluacion;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.detallePN.DetallePlanillaNotaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.etapa.EtapaDomain;

import java.util.List;


@Entity
@Table(name = "EVALUACIONES")
public class EvaluacionDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EVAL", nullable = false)
    private Integer id;

    @Column(name = "ID_ETAPA")
    private Integer idEtapa;

    @Column(name = "NOMBRE_EVAL", nullable = false)
    private String nombre;

    @Column(name = "TP_EVAL", nullable = false)
    private Double totalPunto;

    @Column(name = "ESTADO_EVAL", nullable = false)
    private Boolean estado;


    public Integer getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "ID_ETAPA", insertable = false, updatable = false)
    private EtapaDomain etapa;

    @OneToMany(mappedBy = "evaluacion")
    private List<DetallePlanillaNotaDomain> DetallesPlanillaNotas;


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getTotalPunto() {
        return totalPunto;
    }

    public void setTotalPunto(Double totalPunto) {
        this.totalPunto = totalPunto;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public EtapaDomain getEtapa() {
        return etapa;
    }

    public void setEtapa(EtapaDomain etapa) {
        this.etapa = etapa;
    }

    public List<DetallePlanillaNotaDomain> getDetallesPlanillaNotas() {
        return DetallesPlanillaNotas;
    }

    public void setDetallesPlanillaNotas(List<DetallePlanillaNotaDomain> detallesPlanillaNotas) {
        DetallesPlanillaNotas = detallesPlanillaNotas;
    }
}