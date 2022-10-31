package com.fiuni.apirest.PlanillaCalificacionAPI.service.listaAlumno;


        import com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaAlumno.ListaAlumnoDTO;
        import com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaAlumno.ListaAlumnoResult;
        import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;
        
        public interface IListaAlumnoService extends IBaseService<ListaAlumnoDTO, ListaAlumnoResult> {
        
            public abstract ListaAlumnoDTO update(Integer id, ListaAlumnoDTO dto);
        
            public abstract Boolean delete(Integer id);
        }
        
