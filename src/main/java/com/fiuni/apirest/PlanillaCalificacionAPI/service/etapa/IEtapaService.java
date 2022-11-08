package com.fiuni.apirest.PlanillaCalificacionAPI.service.etapa;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;
import java.util.List;


public interface IEtapaService extends IBaseService<EtapaDTO, EtapaResult> {
    public abstract ResponseEntity<EtapaDTO> update(Integer id, EtapaDTO dto);

    public abstract ResponseEntity<Boolean> delete(Integer id);

    public abstract ResponseEntity<Integer> deleteAbs(Integer id);

    public EtapaDTO getByID(Integer id) throws Exception;
}
