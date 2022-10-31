package com.fiuni.apirest.PlanillaCalificacionAPI.domain.horaCatedra;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.horaProfe.HoraProfesorDomain;

import java.time.*;
import java.util.List;


@Entity
@Table(name = "HORAS_CATEDRAS")
public class HoraCatedraDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HC", nullable = false)
    private Integer id;

    @Column(name = "INICIO_HC", nullable = false)
    private LocalTime inicio;

    @Column(name = "FINAL_HC", nullable = false)
    private LocalTime fin;

    @Column(name = "ESTADO_HC", nullable = false)
    private Boolean estado;

    @OneToMany(mappedBy = "horaCatedra")
    private List<HoraProfesorDomain> horaProfesores;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<HoraProfesorDomain> getHoraProfesores() {
        return horaProfesores;
    }

    public void setHoraProfesores(List<HoraProfesorDomain> horaProfesores) {
        this.horaProfesores = horaProfesores;
    }
}