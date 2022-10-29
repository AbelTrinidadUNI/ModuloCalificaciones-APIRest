package com.fiuni.apirest.PlanillaCalificacionAPI.dao.informe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.informe.InformeDomain;


public class Informe {
    @Repository
    public interface IInformeDao extends CrudRepository<InformeDomain, Integer> {
        public Page<InformeDomain> findAll(Pageable pageable);

    }

}
