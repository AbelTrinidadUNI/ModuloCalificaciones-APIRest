package com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaAlumno;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaDto;

import java.util.List;

public class ListaAlumnoResult extends BaseResult<ListaAlumnoDTO> {
    public ListaAlumnoResult(){

    }
    public ListaAlumnoResult(List<ListaAlumnoDTO> list){
        this.setList(list);
    }

    public List<ListaAlumnoDTO> getLista(){
        return this.getList();
    }
}

