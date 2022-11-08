package com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaMateria;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaConEvaluacionDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "LISTA_MATERIAS")
public class ListaMateriaConAlumnosDTO extends BaseDTO {

    private String nombreMateria;
    private String descripcionClase;
    private Integer idPlanillaNota;
    private DetallePlanillaNotaConEvaluacionDTO detallesNotas;

    @XmlElement
    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    @XmlElement
    public String getDescripcionClase() {
        return descripcionClase;
    }

    public void setDescripcionClase(String descripcionClase) {
        this.descripcionClase = descripcionClase;
    }

    @XmlElement
    public Integer getIdPlanillaNota() {
        return idPlanillaNota;
    }

    public void setIdPlanillaNota(Integer idPlanillaNota) {
        this.idPlanillaNota = idPlanillaNota;
    }


    @XmlElement
    public DetallePlanillaNotaConEvaluacionDTO getDetallesNotas() {
        return detallesNotas;
    }

    public void setDetallesNotas(DetallePlanillaNotaConEvaluacionDTO detallesNotas) {
        this.detallesNotas = detallesNotas;
    }
}
