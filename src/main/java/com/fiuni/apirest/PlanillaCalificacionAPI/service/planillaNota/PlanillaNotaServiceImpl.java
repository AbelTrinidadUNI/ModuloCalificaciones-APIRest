package com.fiuni.apirest.PlanillaCalificacionAPI.service.planillaNota;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.planillaNota.IPlanillaNotaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.detallePN.DetallePlanillaNotaConEvaluacionDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaDto;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaTableableDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.detallePN.DetallePlanillaNotaServiceImpl;
import com.library.domainLibrary.domain.planillaNota.PlanillaNotaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlanillaNotaServiceImpl extends BaseServiceImpl<PlanillaNotaDto, PlanillaNotaDomain, PlanillaNotaResult> implements IPlanillaNotaService {

    @Autowired
    private IPlanillaNotaDao pNotas;


    @Override
    public ResponseEntity<PlanillaNotaDto> save(PlanillaNotaDto dto) {
        dto.setEstado(dto.getEstado() == null ? true : dto.getEstado());

        PlanillaNotaDto response = convertDomainToDto(pNotas.save(convertDtoToDomain(dto)));

        return response != null ? new ResponseEntity<PlanillaNotaDto>(response, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<PlanillaNotaDto> getById(Integer id) throws Exception {
        PlanillaNotaDto response = pNotas.findById(id).map(p -> convertDomainToDto(p)).orElse(null);

        return response != null ? new ResponseEntity<PlanillaNotaDto>(response, HttpStatus.OK)
                : new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<PlanillaNotaResult> getAll(Pageable pageable) {
        try {

            Page<PlanillaNotaDomain> page = pNotas.findAll(pageable);
            System.out.println("Se obtiene la pagina");
            if (page != null) {
                PlanillaNotaResult response = new PlanillaNotaResult(page.map(p -> convertDomainToDto(p)).toList());
                System.out.println("Se convierten las paginas");

                return response != null && response.getTotal() > 0 ? new ResponseEntity<PlanillaNotaResult>(response, HttpStatus.OK)
                        : new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }



    @Override
    @Transactional
    public ResponseEntity<PlanillaNotaDto> update(Integer id, PlanillaNotaDto dto) {
        if (dto.getEstado() != null && dto.getIdListaMateria() != null) {
            PlanillaNotaDto response = pNotas.findById(id).map(d -> {

                d.setEstado(dto.getEstado());
                d.setIdListaMateria(dto.getIdListaMateria());

                dto.setId(d.getId());
                return save(dto);
            }).orElse(null) != null ? dto : null;

            return response != null ? new ResponseEntity<PlanillaNotaDto>(HttpStatus.NO_CONTENT)
                    : new ResponseEntity<>(HttpStatus.CONFLICT);

        }
        return null;
    }

    @Override
    @Transactional
    public ResponseEntity<Boolean> delete(Integer id) {
        Boolean response = pNotas.delete(id);

        return new ResponseEntity<Boolean>(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<PlanillaNotaTableableDTO> findByIdListaMateria(Integer id) {
        PlanillaNotaTableableDTO response = new PlanillaNotaTableableDTO();

        PlanillaNotaDomain pn = pNotas.findFirstByIdListaMateria(id);


        DetallePlanillaNotaServiceImpl aux = new DetallePlanillaNotaServiceImpl();

        response.setId(pn.getId());
        response.setNombreMateria(pn.getListaMateria().getMateria().getNombre());
        response.setDescripcionClase(pn.getListaMateria().getClase().getNombre());
        response.setIdListaMateria(pn.getIdListaMateria());

        List<DetallePlanillaNotaConEvaluacionDTO> listaDetalles = new ArrayList();
        for (int i = 0; i < pn.getDetallesPlanillaNotas().size(); i++) {
            listaDetalles.add(aux.convertDomainToDto2(pn.getDetallesPlanillaNotas().get(i)));
        }
        response.setDetallesNotas(listaDetalles);


        return response != null ? new ResponseEntity<PlanillaNotaTableableDTO>(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @Override
    protected PlanillaNotaDto convertDomainToDto(PlanillaNotaDomain domain) {
        PlanillaNotaDto dto = new PlanillaNotaDto();
        dto.setId(domain.getId());
        dto.setEstado(domain.getEstado());
        dto.setIdListaMateria(domain.getIdListaMateria());
        return dto;
    }

    @Override
    protected PlanillaNotaDomain convertDtoToDomain(PlanillaNotaDto dto) {
        PlanillaNotaDomain domain = new PlanillaNotaDomain();
        domain.setId(dto.getId());
        domain.setIdListaMateria(dto.getIdListaMateria());
        domain.setEstado(dto.getEstado());
        return domain;
    }


}
