package com.fiuni.apirest.PlanillaCalificacionAPI.dao.ciclo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.ciclo.CicloDomain;


public class Ciclo {
    @Repository
    public interface ICicloDao extends CrudRepository<CicloDomain, Integer> {
        public Page<CicloDomain> findAll(Pageable pageable);

    }

}
