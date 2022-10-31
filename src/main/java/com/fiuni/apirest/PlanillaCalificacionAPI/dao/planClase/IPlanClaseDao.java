package com.fiuni.apirest.PlanillaCalificacionAPI.dao.planClase;


import com.fiuni.apirest.PlanillaCalificacionAPI.domain.planClase.PlanClaseDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IPlanClaseDao extends CrudRepository<PlanClaseDomain, Integer> {
    public Page<PlanClaseDomain> findAll(Pageable pageable);


}
