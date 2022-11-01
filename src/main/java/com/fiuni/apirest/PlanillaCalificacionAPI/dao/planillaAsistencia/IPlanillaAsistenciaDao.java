package com.fiuni.apirest.PlanillaCalificacionAPI.dao.planillaAsistencia;

import com.library.domainLibrary.domain.planillaAsistencia.PlanillaAsistenciaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPlanillaAsistenciaDao extends CrudRepository<PlanillaAsistenciaDomain, Integer> {
    public Page<PlanillaAsistenciaDomain> findAll(Pageable pageable);


}
