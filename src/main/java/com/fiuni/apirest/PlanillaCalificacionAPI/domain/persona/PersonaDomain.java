package com.fiuni.apirest.PlanillaCalificacionAPI.domain.persona;

import javax.persistence.*;
import java.time.*;
import java.util.List;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.base.BaseDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.contactoEmergencias.ContactoEmergenciasDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.informe.InformeDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaAlumno.ListaAlumnoDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.listaMateria.ListaMateriaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.rol.RolDomain;


@Entity
@Table(name = "PERSONAS")
public class PersonaDomain implements BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PER", nullable = false)
    private Integer id;

    @Column(name = "ID_ROL")
    private Integer idRol;

    @Column(name = "NOMBRE_PER", nullable = false)
    private String nombre;

    @Column(name = "EMAIL_PER")
    private String email;

    @Column(name = "PASSWORD_PER")
    private String password;

    @Column(name = "FECHA_NACIMIENTO")
    private LocalDateTime fechaNacimiento;

    @Column(name = "DIRECCION_PER")
    private String direccion;

    @Column(name = "TELEFONO_PER")
    private String telefono;

    @Column(name = "GENERO_PER")
    private String genero;

    @Column(name = "CI_PER", nullable = false)
    private String ci;

    @Column(name = "ESTADO_PER", nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "ID_ROL", insertable = false, updatable = false)
    private RolDomain rol;

    @OneToMany(mappedBy = "persona")
    private List<ContactoEmergenciasDomain> contactosEmergencias;

    @OneToMany(mappedBy = "profesor")
    private List<InformeDomain> informes;

    @OneToMany(mappedBy = "profesor")
    private List<ListaMateriaDomain> listaMaterias;

    @OneToMany(mappedBy = "alumno")
    private List<ListaAlumnoDomain> alumnos;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public RolDomain getRol() {
        return rol;
    }

    public void setRol(RolDomain rol) {
        this.rol = rol;
    }

    public List<ContactoEmergenciasDomain> getContactosEmergencias() {
        return contactosEmergencias;
    }

    public void setContactosEmergencias(List<ContactoEmergenciasDomain> contactosEmergencias) {
        this.contactosEmergencias = contactosEmergencias;
    }

    public List<InformeDomain> getInformes() {
        return informes;
    }

    public void setInformes(List<InformeDomain> informes) {
        this.informes = informes;
    }

    public List<ListaMateriaDomain> getListaMaterias() {
        return listaMaterias;
    }

    public void setListaMaterias(List<ListaMateriaDomain> listaMaterias) {
        this.listaMaterias = listaMaterias;
    }

    public List<ListaAlumnoDomain> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<ListaAlumnoDomain> alumnos) {
        this.alumnos = alumnos;
    }
}
