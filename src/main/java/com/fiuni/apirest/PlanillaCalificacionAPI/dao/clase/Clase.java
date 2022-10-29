package com.fiuni.apirest.PlanillaCalificacionAPI.dao.clase;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.clase.ClaseDomain;


public class Clase {
    @Repository
    public interface IClaseDao extends CrudRepository<ClaseDomain, Integer> {
        public Page<ClaseDomain> findAll(Pageable pageable);

    }

}
