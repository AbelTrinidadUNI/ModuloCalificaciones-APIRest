package com.fiuni.apirest.PlanillaCalificacionAPI.dao.detalleInforme;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.detalleInforme.DetalleInformeDomain;


public class DetalleInforme {
    @Repository
    public interface IDetalleInformeDao extends CrudRepository<DetalleInformeDomain, Integer> {
        public Page<DetalleInformeDomain> findAll(Pageable pageable);

    }

}
