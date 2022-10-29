package com.fiuni.apirest.PlanillaCalificacionAPI.dao.etapa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.etapa.EtapaDomain;


public class Etapa {
    @Repository
    public interface IEtapaDao extends CrudRepository<EtapaDomain, Integer> {
        public Page<EtapaDomain> findAll(Pageable pageable);

    }

}
