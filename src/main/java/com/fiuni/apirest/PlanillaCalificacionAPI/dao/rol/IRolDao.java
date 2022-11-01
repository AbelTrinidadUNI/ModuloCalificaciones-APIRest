package com.fiuni.apirest.PlanillaCalificacionAPI.dao.rol;

import com.library.domainLibrary.domain.rol.RolDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRolDao extends CrudRepository<RolDomain, Integer> {
    public Page<RolDomain> findAll(Pageable pageable);


}
