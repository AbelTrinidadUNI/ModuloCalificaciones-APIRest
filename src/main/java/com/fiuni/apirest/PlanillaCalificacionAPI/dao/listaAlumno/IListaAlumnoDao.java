package com.fiuni.apirest.PlanillaCalificacionAPI.dao.listaAlumno;

import com.library.domainLibrary.domain.listaAlumno.ListaAlumnoDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IListaAlumnoDao extends CrudRepository<ListaAlumnoDomain, Integer> {
    public Page<ListaAlumnoDomain> findAll(Pageable pageable);

}


