package com.fiuni.apirest.PlanillaCalificacionAPI.service.base;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.base.BaseResult;
import com.library.domainLibrary.domain.base.BaseDomain;

public abstract class BaseServiceImpl<DTO extends BaseDTO, DOMAIN extends BaseDomain,  RESULT extends BaseResult<DTO>> implements IBaseService<DTO,   RESULT> {

	protected abstract DTO convertDomainToDto(DOMAIN domain);

	protected abstract DOMAIN convertDtoToDomain(DTO dto);

}
