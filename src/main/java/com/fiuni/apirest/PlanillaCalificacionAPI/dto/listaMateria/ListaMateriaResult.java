package com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaMateria;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;

import java.util.List;

public class ListaMateriaResult extends BaseResult<ListaMateriaDTO> {
    public ListaMateriaResult(){

    }
    public ListaMateriaResult(List<ListaMateriaDTO> list){
        this.setList(list);
    }

    public List<ListaMateriaDTO> getLista(){
        return this.getList();
    }
}

