package com.fiuni.apirest.PlanillaCalificacionAPI.dto.colegio;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.clase.ClaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "COLEGIO")
public class ColegioDto extends BaseDTO {

    private String nombreColegio;

    private Boolean estadoColegio = false;



    public void setEstadoColegio(Boolean estadoColegio) {
        this.estadoColegio = estadoColegio;
    }

    @XmlElement
    public Boolean getEstadoColegio() {
        return estadoColegio;
    }

    @XmlElement
    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }


}