package com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaAlumno;

import javax.persistence.*;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.clase.ClaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.detallePA.DetallePlanillaAsistenciaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.detallePN.DetallePlanillaNotaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.persona.PersonaDomain;

import java.util.List;

@Entity
@Table(name = "LISTA_ALUMNOS")
public class ListaAlumnoDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LA", nullable = false)
    private Integer id;

    @Column(name = "ID_CLASE")
    private Integer idClase;

    @Column(name = "ID_PER")
    private Integer idAlumno;

    @Column(name = "ESTADO_LA", nullable = false)
    private Boolean estado;


    @ManyToOne
    @JoinColumn(name = "ID_CLASE", insertable = false, updatable = false)
    private ClaseDomain clase;

    @ManyToOne
    @JoinColumn(name = "ID_PER", insertable = false, updatable = false)
    private PersonaDomain alumno;


    @OneToMany(mappedBy = "listaAlumno")
    private List<DetallePlanillaAsistenciaDomain> detallePlanillaAsistencias;

    @OneToMany(mappedBy = "listaAlumno")
    private List<DetallePlanillaNotaDomain> detallesPlanillaNotas;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public ClaseDomain getClase() {
        return clase;
    }

    public void setClase(ClaseDomain clase) {
        this.clase = clase;
    }

    public PersonaDomain getAlumno() {
        return alumno;
    }

    public void setAlumno(PersonaDomain alumno) {
        this.alumno = alumno;
    }

    public List<DetallePlanillaAsistenciaDomain> getDetallePlanillaAsistencias() {
        return detallePlanillaAsistencias;
    }

    public void setDetallePlanillaAsistencias(List<DetallePlanillaAsistenciaDomain> detallePlanillaAsistencias) {
        this.detallePlanillaAsistencias = detallePlanillaAsistencias;
    }

    public List<DetallePlanillaNotaDomain> getDetallesPlanillaNotas() {
        return detallesPlanillaNotas;
    }

    public void setDetallesPlanillaNotas(List<DetallePlanillaNotaDomain> detallesPlanillaNotas) {
        this.detallesPlanillaNotas = detallesPlanillaNotas;
    }
}