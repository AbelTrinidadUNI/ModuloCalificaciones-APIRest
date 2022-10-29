package com.fiuni.apirest.PlanillaCalificacionAPI.dao.detallePA;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.detallePA.DetallePADomain;


public class DetallePA {
    @Repository
    public interface IDetallePADao extends CrudRepository<DetallePADomain, Integer> {
        public Page<DetallePADomain> findAll(Pageable pageable);

    }

}
