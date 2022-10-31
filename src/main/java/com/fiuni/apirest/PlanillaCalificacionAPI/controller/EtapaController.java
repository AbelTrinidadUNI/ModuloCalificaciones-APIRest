package com.fiuni.apirest.PlanillaCalificacionAPI.controller;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.etapa.IEtapaService;
import com.fiuni.apirest.PlanillaCalificacionAPI.utils.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/etapas")
public class EtapaController {

	@Autowired
	private IEtapaService etapaService;

	@GetMapping("/{id}")
	public EtapaDTO getById(@PathVariable(value = "id") Integer cityId) {
		return etapaService.getById(cityId);
	}

	@GetMapping(path = "/page/{page_num}")
	public EtapaResult getClients(@PathVariable(value = "page_num")Integer pageNum) {
		return etapaService.getAll(PageRequest.of(pageNum, Settings.PAGE_SIZE));
	}

	@PostMapping
	public EtapaDTO save(@Validated @RequestBody EtapaDTO etapa) {
		return etapaService.save(etapa);
	}

	@PutMapping("/{id}")
	public EtapaDTO putEtapa(@PathVariable(value = "id") Integer id, @RequestBody EtapaDTO dto) {
		return etapaService.update(id, dto);
	}

	@DeleteMapping("/{id}")
	public boolean putEtapa(@PathVariable(value = "id") Integer id) {
		return etapaService.delete(id);
	}


}