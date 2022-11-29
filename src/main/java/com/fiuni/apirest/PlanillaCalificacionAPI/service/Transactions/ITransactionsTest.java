package com.fiuni.apirest.PlanillaCalificacionAPI.service.Transactions;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaListEvalDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.IBaseService;

public interface ITransactionsTest extends IBaseService<EtapaDTO, EtapaResult> {
    public abstract EtapaDTO update(Integer id, EtapaDTO dto);

    public abstract Boolean delete(Integer id);

    public abstract Integer deleteAbs(Integer id);


    public abstract Boolean saveAllRequired(EtapaListEvalDTO dto);

    public abstract Boolean saveAllSupports(EtapaListEvalDTO dto);

    public abstract Boolean saveAllNotSupported(EtapaListEvalDTO dto);

    public abstract Boolean saveAllRequiresNew(EtapaListEvalDTO dto);

    public abstract Boolean saveAllNever(EtapaListEvalDTO dto);

    public abstract Boolean saveAllMandatory(EtapaListEvalDTO dto);

}
