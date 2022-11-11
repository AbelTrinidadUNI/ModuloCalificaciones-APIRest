package com.fiuni.apirest.PlanillaCalificacionAPI.service.base;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.*;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface IBaseService<DTO extends BaseDTO, R extends BaseResult<DTO>> {
    public DTO save(DTO dto) throws Exception;

    public DTO getById(Integer id) throws Exception;



    public R getAll(Pageable pageable) throws Exception;

}
