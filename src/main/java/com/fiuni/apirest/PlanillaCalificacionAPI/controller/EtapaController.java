package com.fiuni.apirest.PlanillaCalificacionAPI.controller;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.etapa.IEtapaService;
import com.fiuni.apirest.PlanillaCalificacionAPI.utils.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/etapas")
public class EtapaController {

	@Autowired
	private IEtapaService etapaService;

	@GetMapping("/{id}")
	public ResponseEntity<EtapaDTO> getById(@PathVariable(value = "id") Integer cityId) {
		return etapaService.getById(cityId);
	}

	@GetMapping(path = "/page/{page_num}")
	public ResponseEntity<EtapaResult> getClients(@PathVariable(value = "page_num")Integer pageNum) {
		return etapaService.getAll(PageRequest.of(pageNum, Settings.PAGE_SIZE));
	}

	@PostMapping
	public ResponseEntity<EtapaDTO> save(@Validated @RequestBody EtapaDTO etapa) {
		return etapaService.save(etapa);
	}

	@PutMapping("/{id}")
	public ResponseEntity<EtapaDTO> putEtapa(@PathVariable(value = "id") Integer id, @RequestBody EtapaDTO dto) {
		return etapaService.update(id, dto);
	}

	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<Boolean> deleteEtapa(@PathVariable(value = "id") Integer id) {
		return etapaService.delete(id);
	}

	@DeleteMapping("/absolute/{id}")
	public ResponseEntity<Integer> deleteAbsEtapa(@PathVariable(value = "id") Integer id){
		return etapaService.deleteAbs(id);
	}
}
