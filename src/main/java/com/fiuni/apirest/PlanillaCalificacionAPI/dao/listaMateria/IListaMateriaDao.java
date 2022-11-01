package com.fiuni.apirest.PlanillaCalificacionAPI.dao.listaMateria;

import com.library.domainLibrary.domain.listaMateria.ListaMateriaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IListaMateriaDao extends CrudRepository<ListaMateriaDomain, Integer> {
    public Page<ListaMateriaDomain> findAll(Pageable pageable);

}


