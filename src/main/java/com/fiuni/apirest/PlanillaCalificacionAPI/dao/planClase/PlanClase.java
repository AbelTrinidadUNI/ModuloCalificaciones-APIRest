package com.fiuni.apirest.PlanillaCalificacionAPI.dao.planClase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.planClase.PlanClaseDomain;


public class PlanClase {
    @Repository
    public interface IPlanClaseDao extends CrudRepository<PlanClaseDomain, Integer> {
        public Page<PlanClaseDomain> findAll(Pageable pageable);

    }

}
