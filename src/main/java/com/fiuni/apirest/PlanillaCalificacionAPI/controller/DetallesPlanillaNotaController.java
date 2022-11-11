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
import org.springframework.http.HttpStatus;
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
        DetallePlanillaNotaDTO response = detallePlanillaNotaService.getById(planillaId);

        return response != null ? new ResponseEntity(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/page/{page_num}")
    public ResponseEntity<DetallePlanillaNotaResult> getPlanillaNota(@PathVariable(value = "page_num")Integer pageNum) throws Exception{
        DetallePlanillaNotaResult response = detallePlanillaNotaService.getAll(PageRequest.of(pageNum, Settings.PAGE_SIZE));
        return response != null ? new ResponseEntity<DetallePlanillaNotaResult>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<DetallePlanillaNotaDTO> save(@Validated @RequestBody DetallePlanillaNotaDTO planilla) throws Exception{
        DetallePlanillaNotaDTO response = detallePlanillaNotaService.save(planilla);

        return response != null ? new ResponseEntity<DetallePlanillaNotaDTO>(response, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePlanillaNotaDTO> putEtapa(@PathVariable(value = "id") Integer id, @RequestBody DetallePlanillaNotaDTO dto) {
        DetallePlanillaNotaDTO response = detallePlanillaNotaService.update(id, dto);
        return response != null ? new ResponseEntity<DetallePlanillaNotaDTO>(response, HttpStatus.NO_CONTENT) :
                new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id") Integer id) {
        Boolean response = detallePlanillaNotaService.delete(id);
        return new ResponseEntity<Boolean>(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
