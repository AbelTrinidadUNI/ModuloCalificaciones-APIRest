package com.fiuni.apirest.PlanillaCalificacionAPI.dao.listaAlumno;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.listaAlumno.ListaAlumnoDomain;


public class ListaAlumno {
    @Repository
    public interface IListaAlumnoDao extends CrudRepository<ListaAlumnoDomain, Integer> {
        public Page<ListaAlumnoDomain> findAll(Pageable pageable);

    }

}
