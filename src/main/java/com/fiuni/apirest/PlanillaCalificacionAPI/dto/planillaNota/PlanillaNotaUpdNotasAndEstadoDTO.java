package com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePNUptPuntajeEsstadoDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "PLANILLA_NOTAS")
public class PlanillaNotaUpdNotasAndEstadoDTO extends BaseDTO {

    private List<DetallePNUptPuntajeEsstadoDTO> detalles;

    @XmlElement
    public List<DetallePNUptPuntajeEsstadoDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePNUptPuntajeEsstadoDTO> detalles) {
        this.detalles = detalles;
    }
}
