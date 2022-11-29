package com.fiuni.apirest.PlanillaCalificacionAPI.dao.etapa;

import com.library.domainLibrary.domain.etapa.EtapaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IEtapaDao extends CrudRepository<EtapaDomain, Integer> {
    public Page<EtapaDomain> findAll(Pageable pageable);

    public Page<EtapaDomain> getByEstadoTrue(Pageable pageable);

    //@Query("DELETE FROM EtapaDomain e JOIN EvaluacionDomain ev ON  e.id = ev.id")
    //@EntityGraph(attributePaths = {"evaluaciones"})
    /*@Query(value = "DELETE FROM etapas et " +
            "WHERE (SELECT COUNT(res.id) " +
            "FROM (SELECT e.id " +
            "FROM EtapaDomain AS e " +
            "INNER JOIN EvaluacionDomain AS ev " +
            "ON (e.id = ev.id) " +
            "WHERE e.id = ?1) AS res) < 1 AND et.id = ?1")*/
    //@Query(value = "DELETE FROM EtapaDomain AS e WHERE (SELECT count(et.id) FROM EtapaDomain et INNER JOIN et.evaluaciones)< 1 AND e.id = ?1")

    /*@Query(value = "UPDATE EvaluacionDomain ev EtapaDomain et SET ev.estado=1, et.estado = 0 WHERE ev.idEtapa = et.idEtapa AND et.idEtapa = ?1")
    public Integer hiddenCascadeById(Integer id);
*/
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM EtapaDomain ed WHERE ((SELECT count(ev.idEtapa) FROM EvaluacionDomain ev WHERE ev.idEtapa = ?1) < 1) AND ed.id = ?1")
    public Integer deleteAbsolut(Integer id);


    //SELECT * from etapas e LEFT JOIN evaluaciones ev ON e.ID_ETAPA = ev.id_etapa WHERE ev.id_etapa is null

    @Query(value = "SELECT e FROM EtapaDomain e LEFT JOIN EvaluacionDomain ev ON e.id = ev.id WHERE ev IS NULL")
    public List<EtapaDomain> getAllWithoutUse();

}
