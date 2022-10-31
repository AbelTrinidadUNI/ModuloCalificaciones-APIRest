package com.fiuni.apirest.PlanillaCalificacionAPI.dto.materia;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaAlumno.ListaAlumnoDTO;

import java.util.List;


public class MateriaResult extends BaseResult<MateriaDTO> {
    public MateriaResult() {

    }

    public MateriaResult(List<MateriaDTO> list) {
        this.setList(list);
    }

    public List<MateriaDTO> getLista() {
        return this.getList();
    }
}

