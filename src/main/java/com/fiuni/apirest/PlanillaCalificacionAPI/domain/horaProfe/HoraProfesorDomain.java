package com.fiuni.apirest.PlanillaCalificacionAPI.domain.horaProfe;

import javax.persistence.*;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaMateria.ListaMateriaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.dia.DiaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.horaCatedra.HoraCatedraDomain;


@Entity
@Table(name = "HORAS_PROFES")
public class HoraProfesorDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HP", nullable = false)
    private Integer id;

    @Column(name = "ID_HC")
    private Integer idHoraCatedra;

    @Column(name = "ID_LISTMAT")
    private Integer idListaMateria;

    @Column(name = "ID_DIAS")
    private Integer idDias;

    @Column(name = "ESTADO_HP", nullable = false)
    private Boolean estado;


    @ManyToOne
    @JoinColumn(name = "ID_DIAS", insertable = false, updatable = false) //el name pertenece a la propiedad dentro de esta entidad
    private DiaDomain dia;

    @ManyToOne
    @JoinColumn(name = "ID_HC", insertable = false, updatable = false) //el name pertenece a la propiedad dentro de esta entidad
    private HoraCatedraDomain horaCatedra;

    @ManyToOne
    @JoinColumn(name = "ID_LISTMAT", insertable = false, updatable = false) //el name pertenece a la propiedad dentro de esta entidad
    private ListaMateriaDomain listaMateria;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdHoraCatedra() {
        return idHoraCatedra;
    }

    public void setIdHoraCatedra(Integer idHoraCatedra) {
        this.idHoraCatedra = idHoraCatedra;
    }

    public Integer getIdListaMateria() {
        return idListaMateria;
    }

    public void setIdListaMateria(Integer idListaMateria) {
        this.idListaMateria = idListaMateria;
    }

    public Integer getIdDias() {
        return idDias;
    }

    public void setIdDias(Integer idDias) {
        this.idDias = idDias;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public DiaDomain getDia() {
        return dia;
    }

    public void setDia(DiaDomain dia) {
        this.dia = dia;
    }

    public HoraCatedraDomain getHoraCatedra() {
        return horaCatedra;
    }

    public void setHoraCatedra(HoraCatedraDomain horaCatedra) {
        this.horaCatedra = horaCatedra;
    }

    public ListaMateriaDomain getListaMateria() {
        return listaMateria;
    }

    public void setListaMateria(ListaMateriaDomain listaMateria) {
        this.listaMateria = listaMateria;
    }
}