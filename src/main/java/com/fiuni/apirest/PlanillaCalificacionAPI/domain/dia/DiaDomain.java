package com.fiuni.apirest.PlanillaCalificacionAPI.domain.dia;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.horaProfe.HoraProfesorDomain;

import java.util.List;


@Entity
@Table(name = "DIAS")
public class DiaDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIAS", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE_DIAS", nullable = false)
    private String nombre;

    @Column(name = "ESTADO_DIAS", nullable = false)
    private Boolean estado;

    @OneToMany(mappedBy = "dia")
    private List<HoraProfesorDomain> HoraProfesores;


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

    public List<HoraProfesorDomain> getHoraProfesores() {
        return HoraProfesores;
    }

    public void setHoraProfesores(List<HoraProfesorDomain> horaProfesores) {
        HoraProfesores = horaProfesores;
    }
}