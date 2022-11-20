package com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionEtapaListDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "ETAPAS")
public class EtapaListEvalDTO extends BaseDTO {
    private String descripcion;

    private Boolean estado;

    private List<EvaluacionEtapaListDTO> evalauciones;

    public EtapaListEvalDTO(){
        evalauciones = new ArrayList<>();
        estado = true;
        descripcion = "";
    }
    @XmlElement
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlElement
    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlElement
    public List<EvaluacionEtapaListDTO> getEvalauciones() {
        return evalauciones;
    }

    public void setEvalauciones(List<EvaluacionEtapaListDTO> evalauciones) {
        this.evalauciones = evalauciones;
    }
}
