package com.fiuni.apirest.PlanillaCalificacionAPI.dao.colegio;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.colegio.ColegioDomain;


public class Colegio {
    @Repository
    public interface IColegioDao extends CrudRepository<ColegioDomain, Integer> {
        public Page<ColegioDomain> findAll(Pageable pageable);

    }

}
