package com.fiuni.apirest.PlanillaCalificacionAPI.service.planillaNota;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.planillaNota.IPlanillaNotaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaDto;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.planillaNota.PlanillaNotaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.library.domainLibrary.domain.planillaNota.PlanillaNotaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

public class PlanillaNotaServiceImpl extends BaseServiceImpl<PlanillaNotaDto, PlanillaNotaDomain, PlanillaNotaResult> implements IPlanillaNotaService {
    @Autowired
    IPlanillaNotaDao pNotas;

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

    @Override
    public PlanillaNotaDto save(PlanillaNotaDto dto) {
        return convertDomainToDto(pNotas.save(convertDtoToDomain(dto)));
    }

    @Override
    public PlanillaNotaDto getById(Integer id) {
        return pNotas.findById(id).map(p -> convertDomainToDto(p)).orElse(null);
    }

    @Override
    public PlanillaNotaResult getAll(Pageable pageable) {
        PlanillaNotaResult result = new PlanillaNotaResult(pNotas.findAll(pageable).map(p -> convertDomainToDto(p)).toList());
        return result;
    }

    @Override
    public PlanillaNotaDto update(Integer id, PlanillaNotaDto dto) {
        if (dto.getEstado() != null && dto.getIdListaMateria() != null) {
            return pNotas.findById(id).map(d -> {

                d.setEstado(dto.getEstado());
                d.setIdListaMateria(dto.getIdListaMateria());

                dto.setId(d.getId());
                return save(dto);
            }).orElse(null) != null ? dto : null;
        }
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return pNotas.delete(id);
    }
}
