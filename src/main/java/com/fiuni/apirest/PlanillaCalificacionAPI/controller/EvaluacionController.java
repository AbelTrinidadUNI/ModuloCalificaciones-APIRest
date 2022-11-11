package com.fiuni.apirest.PlanillaCalificacionAPI.controller;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.evaluacion.IEvaluacionService;
import com.fiuni.apirest.PlanillaCalificacionAPI.utils.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {
    @Autowired(required = true)
    private IEvaluacionService evaluacionService;

    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionDTO> getById(@PathVariable(value = "id") Integer cityId) throws Exception {
        EvaluacionDTO response = evaluacionService.getById(cityId);

        return response != null ? new ResponseEntity<EvaluacionDTO>(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @GetMapping(path = "/page/{page_num}")
    public ResponseEntity<EvaluacionResult> getClients(@PathVariable(value = "page_num") Integer pageNum) throws Exception {
        EvaluacionResult response = evaluacionService.getAll(PageRequest.of(pageNum, Settings.PAGE_SIZE));

        return response != null ? new ResponseEntity(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<EvaluacionDTO> save(@Validated @RequestBody EvaluacionDTO evaluacion) throws Exception {
        EvaluacionDTO response = evaluacionService.save(evaluacion);

        return response != null ? new ResponseEntity<EvaluacionDTO>(response, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EvaluacionDTO> putEtapa(@PathVariable(value = "id") Integer id, @RequestBody EvaluacionDTO dto) {
        EvaluacionDTO response = evaluacionService.update(id, dto);
        return response != null ? new ResponseEntity<EvaluacionDTO>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> putEtapa(@PathVariable(value = "id") Integer id) {
        Boolean response = evaluacionService.delete(id);

        return new ResponseEntity<Boolean>(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
