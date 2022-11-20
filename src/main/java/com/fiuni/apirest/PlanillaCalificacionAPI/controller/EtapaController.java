package com.fiuni.apirest.PlanillaCalificacionAPI.controller;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaListEvalDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionEtapaListDTO;
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
	@CrossOrigin(origins = "*")
	public ResponseEntity<EtapaDTO> getById(@PathVariable(value = "id") Integer id) throws Exception{
		EtapaDTO dto = etapaService.getById(id);

        l.info("-------- Se solicito una etapa con id: " + id);
		return dto != null ? new ResponseEntity(dto, HttpStatus.OK)
				: new ResponseEntity(HttpStatus.NOT_FOUND);

		//return etapaService.getById(id);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(path = "/page/{page_num}")
	public ResponseEntity<EtapaResult> getEtapasPage(@PathVariable(value = "page_num")Integer pageNum) throws Exception{
		EtapaResult result = etapaService.getAll(PageRequest.of(pageNum, Settings.PAGE_SIZE));

		return result != null ? new ResponseEntity<EtapaResult>(result, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@CrossOrigin(origins = "*")
	@PostMapping
	public ResponseEntity<EtapaDTO> save(@Validated @RequestBody EtapaDTO etapa) throws Exception {
		EtapaDTO response = etapaService.save(etapa);

		return response != null ? new ResponseEntity<EtapaDTO>(response, HttpStatus.CREATED)
				: new ResponseEntity<>(HttpStatus.CONFLICT);
	}


	@CrossOrigin(origins = "*")
	@PostMapping("/all")
	public ResponseEntity<Boolean> saveAll(@Validated @RequestBody EtapaListEvalDTO etapa) throws Exception {
		Boolean resp = etapaService.saveAll(etapa);
		//EtapaListEvalDTO response = new EtapaListEvalDTO();
		//EvaluacionEtapaListDTO eval = new EvaluacionEtapaListDTO();
		//response.getEvalauciones().add(eval);
		return resp != null && resp ? new ResponseEntity<Boolean>(resp, HttpStatus.CREATED)
				: new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public ResponseEntity<EtapaDTO> putEtapa(@PathVariable(value = "id") Integer id, @RequestBody EtapaDTO dto) {
		EtapaDTO response = etapaService.update(id, dto);

		return response != null ? new ResponseEntity<EtapaDTO>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.CONFLICT);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity<Boolean> deleteEtapa(@PathVariable(value = "id") Integer id) {
		Boolean response = etapaService.delete(id);

		return new ResponseEntity<Boolean>(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/absolute/{id}")
	public ResponseEntity<Integer> deleteAbsEtapa(@PathVariable(value = "id") Integer id){
		Integer response = etapaService.deleteAbs(id);

		return new ResponseEntity<Integer>(response, response > 0 ? HttpStatus.OK : HttpStatus.METHOD_NOT_ALLOWED);//ResponseEntity.etapaDao.deleteAbsolut(id);
	}
}
