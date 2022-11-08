package com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaConEvaluacionDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "PLANILLA_NOTAS")
public class PlanillaNotaTableableDTO extends BaseDTO {

    private String nombreMateria;
    private String descripcionClase;

    private Integer idListaMateria;
    private List<DetallePlanillaNotaConEvaluacionDTO> detallesNotas;

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
    public Integer getIdListaMateria() {
        return idListaMateria;
    }

    public void setIdListaMateria(Integer idListaMateria) {
        this.idListaMateria = idListaMateria;
    }


    @XmlElement
    public List<DetallePlanillaNotaConEvaluacionDTO> getDetallesNotas() {
        return detallesNotas;
    }

    public void setDetallesNotas(List<DetallePlanillaNotaConEvaluacionDTO> detallesNotas) {
        this.detallesNotas = detallesNotas;
    }
}
