package com.fiuni.apirest.PlanillaCalificacionAPI.dao.detallePA;

import com.library.domainLibrary.domain.detallePA.DetallePlanillaAsistenciaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDetallePADao extends CrudRepository<DetallePlanillaAsistenciaDomain, Integer> {
    public Page<DetallePlanillaAsistenciaDomain> findAll(Pageable pageable);

}


