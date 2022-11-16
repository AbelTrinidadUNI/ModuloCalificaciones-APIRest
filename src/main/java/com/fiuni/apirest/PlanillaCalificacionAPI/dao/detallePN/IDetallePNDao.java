package com.fiuni.apirest.PlanillaCalificacionAPI.dao.detallePN;

import com.library.domainLibrary.domain.detallePN.DetallePlanillaNotaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
public interface IDetallePNDao extends CrudRepository<DetallePlanillaNotaDomain, Integer> {
    public Page<DetallePlanillaNotaDomain> findAll(Pageable pageable);

    public Page<DetallePlanillaNotaDomain> getByEstadoTrue(Pageable pageable);


    @Query(value = "UPDATE DetallePlanillaNotaDomain SET estado = 0 WHERE id = ?1")
    public Boolean delete(Integer id);

    @Query(value = "SELECT d FROM DetallePlanillaNotaDomain d WHERE d.idPlanillaNota = ?1")
    public List<DetallePlanillaNotaDomain> getAllByIdPlanillaNota(Integer idPN);

    @Query(value = "SELECT DISTINCT(d.idListaAlumno) FROM DetallePlanillaNotaDomain d WHERE d.idPlanillaNota = ?1")
    public List<Integer> getAllDistinctByIdPlanillaNota(Integer idPN);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE DetallePlanillaNotaDomain SET puntaje = ?1, estado = ?2 WHERE id = ?3")
    public Integer updatePuntajeAndEstado(Double puntajeNuevo, Boolean estadoNuevo, Integer id_dpn);
}

