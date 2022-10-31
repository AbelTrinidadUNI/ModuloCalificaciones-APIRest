package com.fiuni.apirest.PlanillaCalificacionAPI.domain.planillaNota;

import javax.persistence.*;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.detallePN.DetallePlanillaNotaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaMateria.ListaMateriaDomain;

import java.util.List;

@Entity
@Table(name = "PLANILLA_ASISTENCIAS")
public class PlanillaNotaDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PN", nullable = false)
    private Integer id;

    @Column(name = "ID_LISTMAT")
    private Integer idListaMateria;

    @Column(name = "ESTADO_PN", nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "ID_LISTMAT", insertable = false, updatable = false)
    private ListaMateriaDomain listaMateria;

    @OneToMany(mappedBy = "planillaNota")
    private List<DetallePlanillaNotaDomain> detallesPlanillaNotas;


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

    public List<DetallePlanillaNotaDomain> getDetallesPlanillaNotas() {
        return detallesPlanillaNotas;
    }

    public void setDetallesPlanillaNotas(List<DetallePlanillaNotaDomain> detallesPlanillaNotas) {
        this.detallesPlanillaNotas = detallesPlanillaNotas;
    }
}
