package com.fiuni.apirest.PlanillaCalificacionAPI.domain.planillaAsistencia;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.detallePA.DetallePlanillaAsistenciaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaMateria.ListaMateriaDomain;

import java.util.List;


@Entity
@Table(name = "PLANILLA_ASISTENCIAS")
public class PlanillaAsistenciaDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PA", nullable = false)
    private Integer id;

    @Column(name = "ID_LISTMAT")
    private Integer idListaMateria;

    @Column(name = "ESTADO_PA", nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "ID_LISTMAT", insertable = false, updatable = false)
    private ListaMateriaDomain listaMateria;

    @OneToMany(mappedBy = "planillaAsistencia")
    private List<DetallePlanillaAsistenciaDomain> detallesPlanillaAsistencias;

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

    public List<DetallePlanillaAsistenciaDomain> getDetallesPlanillaAsistencias() {
        return detallesPlanillaAsistencias;
    }

    public void setDetallesPlanillaAsistencias(List<DetallePlanillaAsistenciaDomain> detallesPlanillaAsistencias) {
        this.detallesPlanillaAsistencias = detallesPlanillaAsistencias;
    }
}
