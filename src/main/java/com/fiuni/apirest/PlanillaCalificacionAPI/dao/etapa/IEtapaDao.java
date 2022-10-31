package com.fiuni.apirest.PlanillaCalificacionAPI.dao.etapa;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.etapa.EtapaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEtapaDao extends CrudRepository<EtapaDomain, Integer> {
    public Page<EtapaDomain> findAll(Pageable pageable);


}
