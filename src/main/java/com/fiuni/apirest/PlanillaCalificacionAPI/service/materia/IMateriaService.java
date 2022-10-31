package com.fiuni.apirest.PlanillaCalificacionAPI.service.materia;


        import com.fiuni.apirest.PlanillaCalificacionAPI.dto.materia.MateriaDTO;
        import com.fiuni.apirest.PlanillaCalificacionAPI.dto.materia.MateriaResult;
        import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;
        
        public interface IMateriaService extends IBaseService<MateriaDTO, MateriaResult> {
        
            public abstract MateriaDTO update(Integer id, MateriaDTO dto);
        
            public abstract Boolean delete(Integer id);
        }
        
