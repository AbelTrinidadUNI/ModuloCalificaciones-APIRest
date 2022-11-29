package com.fiuni.apirest.PlanillaCalificacionAPI.controller;


import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaListEvalDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.Transactions.ITransactionsTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactionTest")
public class TransactionTestController {

    public static final Logger logger = LoggerFactory.getLogger(EtapaController.class);

    @Autowired
    private ITransactionsTest transactionsTest;

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<EtapaDTO> getById(@PathVariable(value = "id") Integer id){
        EtapaDTO response;
        try {
            logger.info("Se solicito el elemento con id: " + id);
            response = transactionsTest.getById(id);
            logger.info("Se encontro el elemento con el id solicitado");
            return response != null ? new ResponseEntity<EtapaDTO>(response, HttpStatus.OK)
                    : new ResponseEntity(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            logger.info("Ocurrio un error durante la busqueda del elemento con el id solicitado");
            throw new RuntimeException(e);
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<EtapaDTO> save(@Validated @RequestBody EtapaDTO etapa) throws Exception {
        EtapaDTO response = transactionsTest.save(etapa);

        return response != null ? new ResponseEntity<EtapaDTO>(response, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/required")
    public ResponseEntity<EtapaListEvalDTO> saveRequired(@Validated @RequestBody EtapaListEvalDTO etapa) throws Exception {
        Boolean response = transactionsTest.saveAllRequired(etapa);

        return response != null && response ? new ResponseEntity<EtapaListEvalDTO>(etapa, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/support")
    public ResponseEntity<EtapaListEvalDTO> saveSupports(@Validated @RequestBody EtapaListEvalDTO etapa) throws Exception {
        Boolean response = transactionsTest.saveAllSupports(etapa);

        return response != null && response ? new ResponseEntity<EtapaListEvalDTO>(etapa, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/notSupported")
    public ResponseEntity<EtapaListEvalDTO> saveNotSupported(@Validated @RequestBody EtapaListEvalDTO etapa) throws Exception {
        Boolean response = transactionsTest.saveAllNotSupported(etapa);

        return response != null && response ? new ResponseEntity<EtapaListEvalDTO>(etapa, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/requiresNew")
    public ResponseEntity<EtapaListEvalDTO> saveRequiresNew(@Validated @RequestBody EtapaListEvalDTO etapa) throws Exception {
        Boolean response = transactionsTest.saveAllRequiresNew(etapa);

        return response != null && response ? new ResponseEntity<EtapaListEvalDTO>(etapa, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/never")
    public ResponseEntity<EtapaListEvalDTO> saveNever(@Validated @RequestBody EtapaListEvalDTO etapa) throws Exception {
        Boolean response = transactionsTest.saveAllNever(etapa);

        return response != null && response ? new ResponseEntity<EtapaListEvalDTO>(etapa, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/mandatory")
    public ResponseEntity<EtapaListEvalDTO> saveMandatory(@Validated @RequestBody EtapaListEvalDTO etapa) throws Exception {
        Boolean response = transactionsTest.saveAllMandatory(etapa);

        return response != null && response ? new ResponseEntity<EtapaListEvalDTO>(etapa, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }


}
