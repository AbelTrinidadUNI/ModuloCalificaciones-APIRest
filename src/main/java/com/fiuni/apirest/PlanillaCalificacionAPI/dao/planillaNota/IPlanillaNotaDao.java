package com.fiuni.apirest.PlanillaCalificacionAPI.dao.planillaNota;

import com.library.domainLibrary.domain.planillaNota.PlanillaNotaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPlanillaNotaDao extends CrudRepository<PlanillaNotaDomain, Integer> {
    public Page<PlanillaNotaDomain> findAll(Pageable pageable);

    public Page<PlanillaNotaDomain> getByEstadoTrue(Pageable pageable);

    @Query(value = "UPDATE PlanillaNotaDomain SET estado = 0 WHERE id = ?1")
    public Boolean delete(Integer id);

   // @Query(value = "SELECT TOP(1) FROM PlanillaNotaDomain WHERE idListaMateria = ?1")
    //public PlanillaNotaDomain getPlanillaNotaByIdListaMateria(Integer idLM);

    public PlanillaNotaDomain findFirstByIdListaMateria(Integer idListaMateria);

    public PlanillaNotaDomain findFirstByIdListaMateriaAndEstadoTrue(Integer idListaMateria);
    //public Integer
}
