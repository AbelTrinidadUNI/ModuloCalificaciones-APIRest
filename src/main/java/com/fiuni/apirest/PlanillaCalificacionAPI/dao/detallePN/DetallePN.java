package com.fiuni.apirest.PlanillaCalificacionAPI.dao.detallePN;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.detallePN.DetallePNDomain;


public class DetallePN {
    @Repository
    public interface IDetallePNDao extends CrudRepository<DetallePNDomain, Integer> {
        public Page<DetallePNDomain> findAll(Pageable pageable);

    }

}
