package com.fiuni.apirest.PlanillaCalificacionAPI.domain.contactoEmergencias;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.persona.PersonaDomain;


@Entity
@Table(name = "ContactosEmergencias")
public class ContactoEmergenciasDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CE", nullable = false)
    private Integer id;

    @Column(name = "ID_PER", nullable = false)
    private Integer idPersona;

    @Column(name = "NOMBRE_CE", nullable = false)
    private String nombre;

    @Column(name = "RELACION_CE", nullable = false)
    private String relacion;

    @Column(name = "CONTACTO_CE", nullable = false)
    private String contacto;

    @Column(name = "ESTADO_CE", nullable = false)
    private Boolean estado = false;

    @ManyToOne
    @JoinColumn(name = "ID_PER", insertable = false, updatable = false)
    private PersonaDomain persona;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion) {
        this.relacion = relacion;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public PersonaDomain getPersona() {
        return persona;
    }

    public void setPersona(PersonaDomain persona) {
        this.persona = persona;
    }
}