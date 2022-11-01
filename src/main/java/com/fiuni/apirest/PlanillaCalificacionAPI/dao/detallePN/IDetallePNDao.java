package com.fiuni.apirest.PlanillaCalificacionAPI.dao.detallePN;

import com.library.domainLibrary.domain.detallePN.DetallePlanillaNotaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDetallePNDao extends CrudRepository<DetallePlanillaNotaDomain, Integer> {
    public Page<DetallePlanillaNotaDomain> findAll(Pageable pageable);

}

