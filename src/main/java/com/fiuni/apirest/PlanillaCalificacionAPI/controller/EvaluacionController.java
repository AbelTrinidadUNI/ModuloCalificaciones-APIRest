package com.fiuni.apirest.PlanillaCalificacionAPI.controller;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.detallePN.IDetallePNDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dao.evaluacion.IEvaluacionDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionNuevaEnTablaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.evaluacion.IEvaluacionService;
import com.fiuni.apirest.PlanillaCalificacionAPI.utils.Settings;
import com.library.domainLibrary.domain.detallePN.DetallePlanillaNotaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {
    @Autowired(required = true)
    private IEvaluacionService evaluacionService;


    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionDTO> getById(@PathVariable(value = "id") Integer cityId) throws Exception {
        EvaluacionDTO response = evaluacionService.getById(cityId);

        return response != null ? new ResponseEntity<EvaluacionDTO>(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);

    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/page/{page_num}")
    public ResponseEntity<EvaluacionResult> getClients(@PathVariable(value = "page_num") Integer pageNum) throws Exception {
        EvaluacionResult response = evaluacionService.getAll(PageRequest.of(pageNum, Settings.PAGE_SIZE));

        return response != null ? new ResponseEntity(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<EvaluacionDTO> save(@Validated @RequestBody EvaluacionDTO evaluacion) throws Exception {
        EvaluacionDTO response = evaluacionService.save(evaluacion);

        return response != null ? new ResponseEntity<EvaluacionDTO>(response, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }


    /*
    guarda una evaluacion y si la etapa recibida no existe se crea y se le asoci y luego se crean los
    detalles de la planilla para esa evaluacion
    */
    @CrossOrigin(origins = "*")
    @PostMapping("/fromTable")
    public ResponseEntity<Boolean> saveEvaluacion(@Validated @RequestBody EvaluacionNuevaEnTablaDTO evaluacion) throws Exception {
        Boolean response = evaluacionService.saveFromTable(evaluacion);
        return response != null && response? new ResponseEntity<Boolean>(response, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<EvaluacionDTO> putEtapa(@PathVariable(value = "id") Integer id, @RequestBody EvaluacionDTO dto) {
        EvaluacionDTO response = evaluacionService.update(id, dto);
        return response != null ? new ResponseEntity<EvaluacionDTO>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> putEtapa(@PathVariable(value = "id") Integer id) {
        Boolean response = evaluacionService.delete(id);

        return new ResponseEntity<Boolean>(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
