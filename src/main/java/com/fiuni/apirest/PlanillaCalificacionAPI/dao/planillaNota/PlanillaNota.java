package com.fiuni.apirest.PlanillaCalificacionAPI.dao.planillaNota;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.planillaNota.PlanillaNotaDomain;


public class PlanillaNota {
    @Repository
    public interface IPlanillaNotaDao extends CrudRepository<PlanillaNotaDomain, Integer> {
        public Page<PlanillaNotaDomain> findAll(Pageable pageable);

    }

}
