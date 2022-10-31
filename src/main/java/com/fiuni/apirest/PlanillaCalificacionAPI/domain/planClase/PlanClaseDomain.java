package com.fiuni.apirest.PlanillaCalificacionAPI.domain.planClase;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaMateria.ListaMateriaDomain;


@Entity
@Table(name = "PLANES_DE_CLASE")
public class PlanClaseDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PC", nullable = false)
    private Integer id;

    @Column(name = "ID_LISTMAT")
    private Integer idListaMateria;

    @Column(name = "NOMBRE_PC", nullable = false)
    private String nombre;

    @Column(name = "DIRECCION_PC", nullable = false)
    private String url;

    @Column(name = "ESTADO_PC", nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "ID_LISTMAT", insertable = false, updatable = false)
    private ListaMateriaDomain listaMateria;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdListaMateria() {
        return idListaMateria;
    }

    public void setIdListaMateria(Integer idListaMateria) {
        this.idListaMateria = idListaMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public ListaMateriaDomain getListaMateria() {
        return listaMateria;
    }

    public void setListaMateria(ListaMateriaDomain listaMateria) {
        this.listaMateria = listaMateria;
    }
}
