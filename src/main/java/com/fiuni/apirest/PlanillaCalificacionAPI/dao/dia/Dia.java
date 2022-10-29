package com.fiuni.apirest.PlanillaCalificacionAPI.dao.dia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.dia.DiaDomain;


public class Dia {
    @Repository
    public interface IDiaDao extends CrudRepository<DiaDomain, Integer> {
        public Page<DiaDomain> findAll(Pageable pageable);

    }

}
