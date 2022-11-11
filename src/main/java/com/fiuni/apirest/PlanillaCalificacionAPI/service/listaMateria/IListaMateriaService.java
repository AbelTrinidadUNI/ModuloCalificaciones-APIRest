package com.fiuni.apirest.PlanillaCalificacionAPI.service.listaMateria;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaMateria.ListaMateriaConAlumnosDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaMateria.ListaMateriaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaMateria.ListaMateriaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

public interface IListaMateriaService extends IBaseService<ListaMateriaDTO, ListaMateriaResult> {

    public abstract ListaMateriaDTO update(Integer id, ListaMateriaDTO dto);

    public abstract Boolean delete(Integer id);

    //public abstract ResponseEntity<ListaMateriaConAlumnosDTO> getFullById(Integer id);
}
        
