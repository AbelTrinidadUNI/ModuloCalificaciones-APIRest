package com.fiuni.apirest.PlanillaCalificacionAPI.dto.base;

import java.io.Serializable;
import java.util.List;

public abstract class BaseResult<DTO extends BaseDTO> implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DTO> _dtos;
	private Integer total = 0;
	private Integer totalPages = 0;
	protected List<DTO> getList() {
		return _dtos;
	}

	protected void setList(List<DTO> dtos) {
		_dtos = dtos;
	}

	public Integer getTotal() {
		return null == _dtos ? 0 : _dtos.size();
	}

	public void setTotal(Integer total){
		this.total = total;
	}

	public Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
}
