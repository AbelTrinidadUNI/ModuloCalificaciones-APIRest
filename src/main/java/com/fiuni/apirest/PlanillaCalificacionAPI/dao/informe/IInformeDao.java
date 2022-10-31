package com.fiuni.apirest.PlanillaCalificacionAPI.dao.informe;

import com.fiuni.apirest.PlanillaCalificacionAPI.domain.informe.InformeDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IInformeDao extends CrudRepository<InformeDomain, Integer> {
    public Page<InformeDomain> findAll(Pageable pageable);

}


