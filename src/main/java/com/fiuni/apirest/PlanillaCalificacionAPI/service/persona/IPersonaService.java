package com.fiuni.apirest.PlanillaCalificacionAPI.service.persona;


        import com.fiuni.apirest.PlanillaCalificacionAPI.dto.persona.PersonaDTO;
        import com.fiuni.apirest.PlanillaCalificacionAPI.dto.persona.PersonaResult;
        import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;
        
        public interface IPersonaService extends IBaseService<PersonaDTO, PersonaResult> {
        
            public abstract PersonaDTO update(Integer id, PersonaDTO dto);
        
            public abstract Boolean delete(Integer id);
        }
        
