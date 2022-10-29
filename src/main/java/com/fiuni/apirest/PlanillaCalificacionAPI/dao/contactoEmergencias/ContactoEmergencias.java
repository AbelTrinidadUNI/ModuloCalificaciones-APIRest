package com.fiuni.apirest.PlanillaCalificacionAPI.dao.contactoEmergencias;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.contactoEmergencias.ContactoEmergenciasDomain;


public class ContactoEmergencias {
    @Repository
    public interface IContactoEmergenciasDao extends CrudRepository<ContactoEmergenciasDomain, Integer> {
        public Page<ContactoEmergenciasDomain> findAll(Pageable pageable);

    }

}
