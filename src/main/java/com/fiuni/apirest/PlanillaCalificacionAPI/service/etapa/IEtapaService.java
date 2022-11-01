package com.fiuni.apirest.PlanillaCalificacionAPI.service.etapa;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.List;


public interface IEtapaService extends IBaseService<EtapaDTO, EtapaResult> {
    public abstract EtapaDTO update(Integer id, EtapaDTO dto);

    public abstract Boolean delete(Integer id);

    public abstract Integer deleteAbs(Integer id);
}
