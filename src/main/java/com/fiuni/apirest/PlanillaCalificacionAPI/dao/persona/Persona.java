package com.fiuni.apirest.PlanillaCalificacionAPI.dao.persona;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.persona.PersonaDomain;


public class Persona {
    @Repository
    public interface IPersonaDao extends CrudRepository<PersonaDomain, Integer> {
        public Page<PersonaDomain> findAll(Pageable pageable);

    }

}
