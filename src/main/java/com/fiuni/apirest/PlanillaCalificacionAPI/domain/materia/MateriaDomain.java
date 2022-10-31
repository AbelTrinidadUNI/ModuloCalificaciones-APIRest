package com.fiuni.apirest.PlanillaCalificacionAPI.domain.materia;

import javax.persistence.*;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaMateria.ListaMateriaDomain;

import java.util.List;


@Entity
@Table(name = "MATERIAS")
public class MateriaDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MATERIA", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE_MATERIA" , nullable = false)
    private String  nombre;

    @Column(name = "ESTADO_MATERIA" , nullable = false)
    private Boolean estado;

    @OneToMany(mappedBy = "materia")
    private List<ListaMateriaDomain> listaMaterias;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<ListaMateriaDomain> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<ListaMateriaDomain> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }
}
