package com.fiuni.apirest.PlanillaCalificacionAPI.controller;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.evaluacion.IEvaluacionService;
import com.fiuni.apirest.PlanillaCalificacionAPI.utils.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {
    @Autowired(required = true)
    private IEvaluacionService evaluacionService;

    @GetMapping("/{id}")
    public EvaluacionDTO getById(@PathVariable(value = "id") Integer cityId) {
        return evaluacionService.getById(cityId);
    }

    @GetMapping(path = "/page/{page_num}")
    public EvaluacionResult getClients(@PathVariable(value = "page_num")Integer pageNum) {
        return evaluacionService.getAll(PageRequest.of(pageNum, Settings.PAGE_SIZE));
    }

    @PostMapping
    public EvaluacionDTO save(@Validated @RequestBody EvaluacionDTO evaluacion) {
        return evaluacionService.save(evaluacion);
    }

    @PutMapping("/{id}")
    public EvaluacionDTO putEtapa(@PathVariable(value = "id") Integer id, @RequestBody EvaluacionDTO dto) {
        return evaluacionService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean putEtapa(@PathVariable(value = "id") Integer id) {
        return evaluacionService.delete(id);
    }

}
