package com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.detallePN.DetallePlanillaNotaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;

import java.util.List;


@XmlRootElement(name = "EVALUACIONES")
public class EvaluacionDTO extends BaseDTO {

    private Integer idEtapa;

    private String nombre;

    private Double totalPunto;

    private Boolean estado;

    private EtapaDTO etapaDTO;


    @XmlElement
    public Integer getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    @XmlElement
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlElement
    public Double getTotalPunto() {
        return totalPunto;
    }

    public void setTotalPunto(Double totalPunto) {
        this.totalPunto = totalPunto;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public EtapaDTO getEtapaDTO() {
        return etapaDTO;
    }

    public void setEtapaDTO(EtapaDTO etapaDTO) {
        this.etapaDTO = etapaDTO;
    }
}