package com.fiuni.apirest.PlanillaCalificacionAPI.dao.contactoEmergencias;

import com.library.domainLibrary.domain.contactoEmergencias.ContactoEmergenciasDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface IContactoEmergenciasDao extends CrudRepository<ContactoEmergenciasDomain, Integer> {
    public Page<ContactoEmergenciasDomain> findAll(Pageable pageable);

}


