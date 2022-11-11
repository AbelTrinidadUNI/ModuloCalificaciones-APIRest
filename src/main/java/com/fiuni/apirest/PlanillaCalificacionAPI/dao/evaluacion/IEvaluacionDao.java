package com.fiuni.apirest.PlanillaCalificacionAPI.dao.evaluacion;

import com.library.domainLibrary.domain.evaluacion.EvaluacionDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IEvaluacionDao extends CrudRepository<EvaluacionDomain, Integer> {
    public Page<EvaluacionDomain> findAll(Pageable pageable);

    public Page<EvaluacionDomain> getByEstadoTrue(Pageable pageable);

}

