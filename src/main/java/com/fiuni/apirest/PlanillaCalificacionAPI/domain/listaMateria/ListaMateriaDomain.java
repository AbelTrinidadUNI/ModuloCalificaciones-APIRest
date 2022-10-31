package com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaMateria;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.horaProfe.HoraProfesorDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.materia.MateriaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.clase.ClaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.persona.PersonaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.planClase.PlanClaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.planillaAsistencia.PlanillaAsistenciaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.planillaNota.PlanillaNotaDomain;

import java.util.List;


@Entity
@Table(name = "LISTA_MATERIAS")
public class ListaMateriaDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LISTMAT", nullable = false)
    private Integer id;

    @Column(name = "ID_CLASE")
    private Integer idClase;

    @Column(name = "ID_MATERIA")
    private Integer idMateria;

    @Column(name = "ID_PROF")
    private Integer idProfesor;

    @Column(name = "ESTADO_LISTMAT", nullable = false)
    private Boolean estado;


    @ManyToOne
    @JoinColumn(name = "ID_CLASE", insertable = false, updatable = false)
    private ClaseDomain clase;

    @ManyToOne
    @JoinColumn(name = "ID_MATERIA", insertable = false, updatable = false)
    private MateriaDomain materia;

    @ManyToOne
    @JoinColumn(name = "ID_PROF", insertable = false, updatable = false)
    private PersonaDomain profesor;

    @OneToMany(mappedBy = "listaMateria")
    private List<HoraProfesorDomain> horasProfesores;

    @OneToMany(mappedBy = "listaMateria")
    private List<PlanillaNotaDomain> planillasNotas;

    @OneToMany(mappedBy = "listaMateria")
    private List<PlanClaseDomain> planesClases;

    @OneToMany(mappedBy = "listaMateria")
    private List<PlanillaAsistenciaDomain> planillasAsistencias;


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

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
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

    public MateriaDomain getMateria() {
        return materia;
    }

    public void setMateria(MateriaDomain materia) {
        this.materia = materia;
    }

    public PersonaDomain getProfesor() {
        return profesor;
    }

    public void setProfesor(PersonaDomain profesor) {
        this.profesor = profesor;
    }

    public List<HoraProfesorDomain> getHorasProfesores() {
        return horasProfesores;
    }

    public void setHorasProfesores(List<HoraProfesorDomain> horasProfesores) {
        this.horasProfesores = horasProfesores;
    }

    public List<PlanillaNotaDomain> getPlanillasNotas() {
        return planillasNotas;
    }

    public void setPlanillasNotas(List<PlanillaNotaDomain> planillasNotas) {
        this.planillasNotas = planillasNotas;
    }

    public List<PlanClaseDomain> getPlanesClases() {
        return planesClases;
    }

    public void setPlanesClases(List<PlanClaseDomain> planesClases) {
        this.planesClases = planesClases;
    }

    public List<PlanillaAsistenciaDomain> getPlanillasAsistencias() {
        return planillasAsistencias;
    }

    public void setPlanillasAsistencias(List<PlanillaAsistenciaDomain> planillasAsistencias) {
        this.planillasAsistencias = planillasAsistencias;
    }
}