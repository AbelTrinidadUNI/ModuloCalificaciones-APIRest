package com.fiuni.apirest.PlanillaCalificacionAPI.dao.materia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.materia.MateriaDomain;


public class Materia {
    @Repository
    public interface IMateriaDao extends CrudRepository<MateriaDomain, Integer> {
        public Page<MateriaDomain> findAll(Pageable pageable);

    }

}
