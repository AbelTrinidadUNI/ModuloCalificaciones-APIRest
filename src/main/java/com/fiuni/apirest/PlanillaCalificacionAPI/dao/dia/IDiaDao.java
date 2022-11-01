package com.fiuni.apirest.PlanillaCalificacionAPI.dao.dia;


import com.library.domainLibrary.domain.dia.DiaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiaDao extends CrudRepository<DiaDomain, Integer> {
    public Page<DiaDomain> findAll(Pageable pageable);

}


