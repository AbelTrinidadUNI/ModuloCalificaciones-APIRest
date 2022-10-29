package com.fiuni.apirest.PlanillaCalificacionAPI.dao.planillaAsistencia;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.planillaAsistencia.PlanillaAsistenciaDomain;


public class PlanillaAsistencia {
    @Repository
    public interface IPlanillaAsistenciaDao extends CrudRepository<PlanillaAsistenciaDomain, Integer> {
        public Page<PlanillaAsistenciaDomain> findAll(Pageable pageable);

    }

}
