package com.fiuni.apirest.PlanillaCalificacionAPI.domain.clase;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.ciclo.CicloDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.colegio.ColegioDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaAlumno.ListaAlumnoDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaMateria.ListaMateriaDomain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CLASES")
public class ClaseDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLASE", nullable = false)
    private Integer id;

    @Column(name = "ID_COLEGIO", nullable = false)
    private Integer idColegio;

    @Column(name = "ID_CICLO", nullable = false)
    private Integer idCiclo;

    @Column(name = "NOMBRE_CLASE", nullable = false)
    private String nombre;

    @Column(name = "TURNO_CLASE", nullable = false)
    private String turno;

    @Column(name = "ANHO_CLASE")
    private Integer anho;

    @Column(name = "ESTADO_CLASE")
    private Boolean estado;


    @ManyToOne
    @JoinColumn(name = "ID_CICLO", insertable = false, updatable = false)
    //el name pertenece a la propiedad dentro de esta entidad
    private CicloDomain ciclo;

    @ManyToOne
    @JoinColumn(name = "ID_COLEGIO", insertable = false, updatable = false)
    private ColegioDomain colegio;

    @OneToMany(mappedBy = "clase")
    private List<ListaAlumnoDomain> ListaAlumnos;

    @OneToMany(mappedBy = "clase")
    private List<ListaMateriaDomain> listaMaterias;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(Integer idColegio) {
        this.idColegio = idColegio;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public CicloDomain getCiclo() {
        return ciclo;
    }

    public void setCiclo(CicloDomain ciclo) {
        this.ciclo = ciclo;
    }

    public ColegioDomain getColegio() {
        return colegio;
    }

    public void setColegio(ColegioDomain colegio) {
        this.colegio = colegio;
    }

    public List<ListaAlumnoDomain> getListaAlumnos() {
        return ListaAlumnos;
    }

    public void setListaAlumnos(List<ListaAlumnoDomain> listaAlumnos) {
        ListaAlumnos = listaAlumnos;
    }

    public List<ListaMateriaDomain> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<ListaMateriaDomain> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }
}
