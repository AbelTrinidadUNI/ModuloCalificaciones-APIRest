package com.fiuni.apirest.PlanillaCalificacionAPI.domain.colegio;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.clase.ClaseDomain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COLEGIO")
public class ColegioDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COLEGIO", nullable = false)
    private Integer id;

    @Column(name = "NOMBRE_COLEGIO", nullable = false)
    private String nombreColegio;

    @Column(name = "ESTADO_COLEGIO", nullable = false)
    private Boolean estadoColegio = false;

    @OneToMany(mappedBy = "colegio")
    private List<ClaseDomain> clases;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEstadoColegio(Boolean estadoColegio) {
        this.estadoColegio = estadoColegio;
    }

    public Boolean getEstadoColegio() {
        return estadoColegio;
    }

    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    public List<ClaseDomain> getClases() {
        return clases;
    }

    public void setClases(List<ClaseDomain> clases) {
        this.clases = clases;
    }
}