package com.fiuni.apirest.PlanillaCalificacionAPI.domain.ciclo;




import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.clase.ClaseDomain;

import javax.persistence.*;
import java.util.*;


@Entity
@Table(name="CICLOS")
public class CicloDomain implements BaseDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CICLO", nullable = false)
    private Integer id;

    @Column(name = "DESCRIPCION_CICLO", nullable = false)
    private String descripcion;

    @Column(name = "ESTADO_CICLO", nullable = false)
    private Boolean estado = false;


    @OneToMany(mappedBy = "ciclo")//ciclo es el nombre del atributo con el cual se la dio manytoone en el objeto "clase"
    private List<ClaseDomain> clases;

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getEstado() {
        return estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
