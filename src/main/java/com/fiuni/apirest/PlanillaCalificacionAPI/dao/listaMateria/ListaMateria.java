package com.fiuni.apirest.PlanillaCalificacionAPI.dao.listaMateria;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.listaMateria.ListaMateriaDomain;


public class ListaMateria {
    @Repository
    public interface IListaMateriaDao extends CrudRepository<ListaMateriaDomain, Integer> {
        public Page<ListaMateriaDomain> findAll(Pageable pageable);

    }

}
