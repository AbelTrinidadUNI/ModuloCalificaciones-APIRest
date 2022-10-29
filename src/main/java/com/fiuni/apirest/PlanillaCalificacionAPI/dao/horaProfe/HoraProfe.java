package com.fiuni.apirest.PlanillaCalificacionAPI.dao.horaProfe;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.horaProfe.HoraProfeDomain;


public class HoraProfe {
    @Repository
    public interface IHoraProfeDao extends CrudRepository<HoraProfeDomain, Integer> {
        public Page<HoraProfeDomain> findAll(Pageable pageable);

    }

}
