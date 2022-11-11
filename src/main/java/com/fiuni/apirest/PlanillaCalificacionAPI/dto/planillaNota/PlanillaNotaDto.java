package com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;

import java.util.List;

@XmlRootElement(name = "PLANILLA_NOTAS")
public class PlanillaNotaDto extends BaseDTO {

    private Integer idListaMateria;

    private List<DetallePlanillaNotaDTO> detalles;
    private Boolean estado;



    @XmlElement
    public Integer getIdListaMateria() {
        return idListaMateria;
    }

    public void setIdListaMateria(Integer idListaMateria) {
        this.idListaMateria = idListaMateria;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public List<DetallePlanillaNotaDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePlanillaNotaDTO> detalles) {
        this.detalles = detalles;
    }
}
