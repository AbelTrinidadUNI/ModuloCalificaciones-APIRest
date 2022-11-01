package com.fiuni.apirest.PlanillaCalificacionAPI.dao.horaProfe;


import com.library.domainLibrary.domain.horaProfe.HoraProfesorDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IHoraProfeDao extends CrudRepository<HoraProfesorDomain, Integer> {
    public Page<HoraProfesorDomain> findAll(Pageable pageable);


}
