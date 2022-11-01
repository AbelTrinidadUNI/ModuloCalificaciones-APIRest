package com.fiuni.apirest.PlanillaCalificacionAPI.dao.planillaNota;

import com.library.domainLibrary.domain.planillaNota.PlanillaNotaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPlanillaNotaDao extends CrudRepository<PlanillaNotaDomain, Integer> {
    public Page<PlanillaNotaDomain> findAll(Pageable pageable);

    @Query(value = "UPDATE PlanillaNotaDomain SET estado = 0 WHERE id = ?1")
    public Boolean delete(Integer id);
}
