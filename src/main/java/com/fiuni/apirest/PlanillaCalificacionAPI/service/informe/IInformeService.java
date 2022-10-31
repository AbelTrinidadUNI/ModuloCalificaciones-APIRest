package com.fiuni.apirest.PlanillaCalificacionAPI.service.informe;


        import com.fiuni.apirest.PlanillaCalificacionAPI.dto.informe.InformeDTO;
        import com.fiuni.apirest.PlanillaCalificacionAPI.dto.informe.InformeResult;
        import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;
        
        public interface IInformeService extends IBaseService<InformeDTO, InformeResult> {
        
            public abstract InformeDTO update(Integer id, InformeDTO dto);
        
            public abstract Boolean delete(Integer id);
        }
        
