package com.fiuni.apirest.PlanillaCalificacionAPI.service.planillaNota;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.planillaNota.IPlanillaNotaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaDto;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.library.domainLibrary.domain.planillaNota.PlanillaNotaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

public class PlanillaNotaServiceImpl extends BaseServiceImpl<PlanillaNotaDto, PlanillaNotaDomain, PlanillaNotaResult> implements IPlanillaNotaService {
    @Autowired
    IPlanillaNotaDao pNotas;


    @Override
    public ResponseEntity<PlanillaNotaDto> save(PlanillaNotaDto dto) {
        dto.setEstado(dto.getEstado() == null ? true : dto.getEstado());

        PlanillaNotaDto response = convertDomainToDto(pNotas.save(convertDtoToDomain(dto)));

        return response != null ? new ResponseEntity<PlanillaNotaDto>(response, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<PlanillaNotaDto> getById(Integer id) {
        PlanillaNotaDto response = pNotas.findById(id).map(p -> convertDomainToDto(p)).orElse(null);

        return response != null ? new ResponseEntity<PlanillaNotaDto>(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<PlanillaNotaResult> getAll(Pageable pageable) {
        PlanillaNotaResult response = new PlanillaNotaResult(pNotas.findAll(pageable).map(p -> convertDomainToDto(p)).toList());
        return response != null ? new ResponseEntity<PlanillaNotaResult>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
