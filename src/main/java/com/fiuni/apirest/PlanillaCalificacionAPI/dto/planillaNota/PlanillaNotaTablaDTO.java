package com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaTablaDTO;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "PLANILLA_NOTAS")
public class PlanillaNotaTablaDTO extends BaseDTO{
    private Integer idListaMateria;
    private Integer idClase;
    private String nombreClase;
    private String turnoClase;
    private Integer anhoClase;
    private Integer idCiclo;
    private String descripcionCiclo;
    private Integer idProfesor;
    private String nombreProfesor;
    private Integer idColegio;
    private String nombreColegio;
    private Integer idMateria;
    private String nombreMateria;
    private List<DetallePlanillaNotaTablaDTO> detalles;

    @XmlElement
    public Integer getIdListaMateria() {
        return idListaMateria;
    }

    public void setIdListaMateria(Integer idListaMateria) {
        this.idListaMateria = idListaMateria;
    }

    @XmlElement
    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    @XmlElement
    public String getNombreClase() {
        return nombreClase;
    }

    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    @XmlElement
    public String getTurnoClase() {
        return turnoClase;
    }

    public void setTurnoClase(String turnoClase) {
        this.turnoClase = turnoClase;
    }

    @XmlElement
    public Integer getAnhoClase() {
        return anhoClase;
    }

    public void setAnhoClase(Integer anhoClase) {
        this.anhoClase = anhoClase;
    }

    @XmlElement
    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    @XmlElement
    public String getDescripcionCiclo() {
        return descripcionCiclo;
    }

    public void setDescripcionCiclo(String descripcionCiclo) {
        this.descripcionCiclo = descripcionCiclo;
    }

    @XmlElement
    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    @XmlElement
    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    @XmlElement
    public Integer getIdColegio() {
        return idColegio;
    }

    public void setIdColegio(Integer idColegio) {
        this.idColegio = idColegio;
    }

    @XmlElement
    public String getNombreColegio() {
        return nombreColegio;
    }

    public void setNombreColegio(String nombreColegio) {
        this.nombreColegio = nombreColegio;
    }

    @XmlElement
    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    @XmlElement
    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    @XmlElement
    public List<DetallePlanillaNotaTablaDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePlanillaNotaTablaDTO> detalles) {
        this.detalles = detalles;
    }
}
