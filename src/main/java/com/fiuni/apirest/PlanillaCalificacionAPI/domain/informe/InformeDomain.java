package com.fiuni.apirest.PlanillaCalificacionAPI.domain.informe;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.detalleInforme.DetalleInformeDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.persona.PersonaDomain;

import java.time.*;
import java.util.List;

@Entity
@Table(name = "INFORMES")
public class InformeDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INF", nullable = false)
    private Integer id;

    @Column(name = "ID_PROF")
    private Integer idProfesor;

    @Column(name = "FECHA_INF", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "TITULO_INF", nullable = false)
    private String titulo;

    @Column(name = "ESTADO_INF", nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "ID_PROF", insertable = false, updatable = false)
    private PersonaDomain profesor;

    @OneToMany(mappedBy = "informe")
    private List<DetalleInformeDomain> detallesInformes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public PersonaDomain getProfesor() {
        return profesor;
    }

    public void setProfesor(PersonaDomain profesor) {
        this.profesor = profesor;
    }

    public List<DetalleInformeDomain> getDetallesInformes() {
        return detallesInformes;
    }

    public void setDetallesInformes(List<DetalleInformeDomain> detallesInformes) {
        this.detallesInformes = detallesInformes;
    }
}