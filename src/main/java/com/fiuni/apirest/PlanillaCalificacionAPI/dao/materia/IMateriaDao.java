package com.fiuni.apirest.PlanillaCalificacionAPI.dao.materia;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.materia.MateriaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IMateriaDao extends CrudRepository<MateriaDomain, Integer> {
    public Page<MateriaDomain> findAll(Pageable pageable);


}
