package com.fiuni.apirest.PlanillaCalificacionAPI.dao.ciclo;


import com.fiuni.apirest.PlanillaCalificacionAPI.domain.ciclo.CicloDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ICicloDao extends CrudRepository<CicloDomain, Integer> {
    public abstract Page<CicloDomain> findAll(Pageable pageable);

}
