package com.fiuni.apirest.PlanillaCalificacionAPI.domain.rol;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.persona.PersonaDomain;

import java.util.List;


@Entity
@Table(name = "ROLES")
public class RolDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ROL", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE_ROL", nullable = false)
    private String nombre;

    @Column(name = "ESTADO_ROL", nullable = false)
    private Boolean estado;

    @OneToMany(mappedBy = "rol")//rol es el nombre del atributo con el cual se la dio manytoone en el objeto "clase"
    private List<PersonaDomain> personaList;

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

    public List<PersonaDomain> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<PersonaDomain> personaList) {
        this.personaList = personaList;
    }
}
