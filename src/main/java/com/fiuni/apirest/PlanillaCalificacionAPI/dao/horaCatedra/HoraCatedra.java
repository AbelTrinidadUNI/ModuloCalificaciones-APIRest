package com.fiuni.apirest.PlanillaCalificacionAPI.dao.horaCatedra;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.horaCatedra.HoraCatedraDomain;


public class HoraCatedra {
    @Repository
    public interface IHoraCatedraDao extends CrudRepository<HoraCatedraDomain, Integer> {
        public Page<HoraCatedraDomain> findAll(Pageable pageable);

    }

}
