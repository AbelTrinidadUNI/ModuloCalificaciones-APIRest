package com.fiuni.apirest.PlanillaCalificacionAPI.service.base;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.*;
import org.springframework.data.domain.Pageable;


public interface IBaseService<DTO extends BaseDTO, R extends BaseResult<DTO>> {
    public DTO save(DTO dto);

    public DTO getById(Integer id);

    public R getAll(Pageable pageable);

}
