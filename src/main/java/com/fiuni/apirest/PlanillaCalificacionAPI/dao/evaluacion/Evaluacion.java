package com.fiuni.apirest.PlanillaCalificacionAPI.dao.evaluacion;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.evaluacion.EvaluacionDomain;


public class Evaluacion {
    @Repository
    public interface IEvaluacionDao extends CrudRepository<EvaluacionDomain, Integer> {
        public Page<EvaluacionDomain> findAll(Pageable pageable);

    }

}
