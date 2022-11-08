package com.fiuni.apirest.PlanillaCalificacionAPI.controller;

import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaDto;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.planillaNota.IPlanillaNotaService;
import com.fiuni.apirest.PlanillaCalificacionAPI.utils.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
        return planillaNotaService.getById(planillaId);


    }

    @GetMapping(path = "/page/{page_num}")
    public ResponseEntity<PlanillaNotaResult> getPlanillaNota(@PathVariable(value = "page_num")Integer pageNum) throws Exception{
        return planillaNotaService.getAll(PageRequest.of(pageNum, Settings.PAGE_SIZE));
    }

    @PostMapping
    public ResponseEntity<PlanillaNotaDto> save(@Validated @RequestBody PlanillaNotaDto planilla) throws Exception{
        return planillaNotaService.save(planilla);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanillaNotaDto> putEtapa(@PathVariable(value = "id") Integer id, @RequestBody PlanillaNotaDto dto) {
        return planillaNotaService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> putEtapa(@PathVariable(value = "id") Integer id) {
        return planillaNotaService.delete(id);
    }
}
