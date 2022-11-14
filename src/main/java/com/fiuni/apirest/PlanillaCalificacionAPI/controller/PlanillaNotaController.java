package com.fiuni.apirest.PlanillaCalificacionAPI.controller;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaDto;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaTablaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaTableableDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.planillaNota.IPlanillaNotaService;
import com.fiuni.apirest.PlanillaCalificacionAPI.utils.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/planillaNota")
public class PlanillaNotaController {
    @Autowired
    private IPlanillaNotaService planillaNotaService;

    @GetMapping("/{id}")
    public ResponseEntity<PlanillaNotaDto> getById(@PathVariable(value = "id") Integer planillaId) throws Exception{
        PlanillaNotaDto response = planillaNotaService.getById(planillaId);

        return response != null ? new ResponseEntity<PlanillaNotaDto>(response, HttpStatus.OK)
                : new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listaMaterias/{id}")
    public ResponseEntity<PlanillaNotaTablaDTO> getByIdListaMaterias(@PathVariable(value = "id") Integer idListaMaterias) throws Exception{
        PlanillaNotaTablaDTO response = planillaNotaService.findByIdListaMateria(idListaMaterias);

        return response != null ? new ResponseEntity<PlanillaNotaTablaDTO>(response, HttpStatus.OK)
                : new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }


    @GetMapping(path = "/page/{page_num}")
    public ResponseEntity<PlanillaNotaResult> getForPage(@PathVariable(value = "page_num")Integer pageNum) throws Exception{
        PlanillaNotaResult response = planillaNotaService.getAll(PageRequest.of(pageNum, Settings.PAGE_SIZE));
        return response != null && response.getTotal() > 0 ? new ResponseEntity<PlanillaNotaResult>(response, HttpStatus.OK)
                : new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<PlanillaNotaDto> save(@Validated @RequestBody PlanillaNotaDto planilla) throws Exception{
        PlanillaNotaDto response = planillaNotaService.save(planilla);
        return response != null ? new ResponseEntity<PlanillaNotaDto>(response, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanillaNotaDto> put(@PathVariable(value = "id") Integer id, @RequestBody PlanillaNotaDto dto) {
        PlanillaNotaDto response = planillaNotaService.update(id, dto);
        return response != null ? new ResponseEntity<PlanillaNotaDto>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") Integer id) {
        Boolean response = planillaNotaService.delete(id);
        return new ResponseEntity<Boolean>(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
