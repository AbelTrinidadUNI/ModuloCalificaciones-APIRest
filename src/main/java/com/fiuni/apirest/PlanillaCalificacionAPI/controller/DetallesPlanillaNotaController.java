package com.fiuni.apirest.PlanillaCalificacionAPI.controller;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaDto;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.detallePN.IDetallePlanillaNotaService;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.planillaNota.IPlanillaNotaService;
import com.fiuni.apirest.PlanillaCalificacionAPI.utils.Settings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/detallesPlanillaNota")
public class DetallesPlanillaNotaController {
    @Autowired(required = true)
    private IDetallePlanillaNotaService detallePlanillaNotaService;

    @GetMapping("/{id}")
    public ResponseEntity<DetallePlanillaNotaDTO> getById(@PathVariable(value = "id") Integer planillaId) throws Exception{
        return detallePlanillaNotaService.getById(planillaId);


    }

    @GetMapping(path = "/page/{page_num}")
    public ResponseEntity<DetallePlanillaNotaResult> getPlanillaNota(@PathVariable(value = "page_num")Integer pageNum) throws Exception{
        return detallePlanillaNotaService.getAll(PageRequest.of(pageNum, Settings.PAGE_SIZE));
    }

    @PostMapping
    public ResponseEntity<DetallePlanillaNotaDTO> save(@Validated @RequestBody DetallePlanillaNotaDTO planilla) throws Exception{
        return detallePlanillaNotaService.save(planilla);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePlanillaNotaDTO> putEtapa(@PathVariable(value = "id") Integer id, @RequestBody DetallePlanillaNotaDTO dto) {
        return detallePlanillaNotaService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> putEtapa(@PathVariable(value = "id") Integer id) {
        return detallePlanillaNotaService.delete(id);
    }
}
