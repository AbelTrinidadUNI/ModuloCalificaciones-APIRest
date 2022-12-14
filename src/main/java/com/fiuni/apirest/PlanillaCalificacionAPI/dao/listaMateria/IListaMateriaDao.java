package com.fiuni.apirest.PlanillaCalificacionAPI.dao.listaMateria;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaMateria.ListaMateriaConAlumnosDTO;
import com.library.domainLibrary.domain.listaMateria.ListaMateriaDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface IListaMateriaDao extends CrudRepository<ListaMateriaDomain, Integer> {
    public Page<ListaMateriaDomain> findAll(Pageable pageable);

    @Query(value = "UPDATE ListaMateriaDomain SET estado = 0 WHERE id = ?1")
    public Boolean delete(Integer id);

    //@Query(value = "SELECT * FROM ListaMateriaDomain ")
    //public ListaMateriaConAlumnosDTO getListaMateriasConAlumnos(Integer idListaMateria);

}


