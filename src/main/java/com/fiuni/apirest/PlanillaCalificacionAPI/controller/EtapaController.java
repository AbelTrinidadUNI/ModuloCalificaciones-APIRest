package com.fiuni.apirest.PlanillaCalificacionAPI.controller;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.etapa.IEtapaService;
import com.fiuni.apirest.PlanillaCalificacionAPI.utils.Settings;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/etapas")
public class EtapaController {
    public static final Logger l = LoggerFactory.getLogger(EtapaController.class);
	@Autowired
	private IEtapaService etapaService;


	@GetMapping("/{id}")
	public ResponseEntity<EtapaDTO> getById(@PathVariable(value = "id") Integer id) throws Exception{
		EtapaDTO dto = etapaService.getByID(id);

        l.info("Se solicito una etapa con id: " + id);
		return dto != null ? new ResponseEntity(dto, HttpStatus.OK)
				: new ResponseEntity(HttpStatus.NOT_FOUND);

		//return etapaService.getById(id);
	}

	@GetMapping(path = "/page/{page_num}")
	public ResponseEntity<EtapaResult> getClients(@PathVariable(value = "page_num")Integer pageNum) throws Exception{
		return etapaService.getAll(PageRequest.of(pageNum, Settings.PAGE_SIZE));
	}

	@PostMapping
	public ResponseEntity<EtapaDTO> save(@Validated @RequestBody EtapaDTO etapa) throws Exception {

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
