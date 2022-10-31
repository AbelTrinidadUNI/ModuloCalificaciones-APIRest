package com.fiuni.apirest.PlanillaCalificacionAPI.service.evaluacion;

import com.fiuni.apirest.PlanillaCalificacionAPI.dao.etapa.IEtapaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dao.evaluacion.IEvaluacionDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.evaluacion.EvaluacionDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EvaluacionServiceImpl extends BaseServiceImpl<EvaluacionDTO, EvaluacionDomain, EvaluacionResult> implements IEvaluacionService {
    @Autowired(required = true)
    private IEvaluacionDao evaluacionDao;
    @Autowired(required = true)
    private IEtapaDao etapaDao;

    @Override
    public EvaluacionDTO save(EvaluacionDTO dto) {
        dto.setEstado(dto.getEstado() == null || dto.getEstado());

        return convertDomainToDto(evaluacionDao.save(convertDtoToDomain(dto)));
    }


    @Override
    public EvaluacionDTO getById(Integer id) {
        return evaluacionDao.findById(id).map(evaluacionDomain -> convertDomainToDto(evaluacionDomain)).orElse(null);
    }

    @Override
    @Transactional
    public EvaluacionResult getAll(Pageable pageable) {
        EvaluacionResult result = new EvaluacionResult(evaluacionDao.findAll(pageable).map(evaluacion -> {
            return convertDomainToDto(evaluacion);
        }).toList());

        return result;
    }

    @Override
    protected EvaluacionDTO convertDomainToDto(EvaluacionDomain domain) {
        EvaluacionDTO dto = new EvaluacionDTO();
        dto.setId(domain.getId());
        dto.setEstado(domain.getEstado());
        dto.setNombre(domain.getNombre());
        dto.setTotalPunto(domain.getTotalPunto());
        dto.setEtapaDTO(etapaDao.findById(domain.getIdEtapa()).map(etapaDomain -> {
            EtapaDTO dtoEtapa = new EtapaDTO();
            dtoEtapa.setId(etapaDomain.getId());
            dtoEtapa.setDescripcion(etapaDomain.getDescripcion());
            dtoEtapa.setEstado(etapaDomain.getEstado());
            return dtoEtapa;
        }).orElse(null));
        dto.setIdEtapa(domain.getIdEtapa());

        return dto;
    }

    @Override
    protected EvaluacionDomain convertDtoToDomain(EvaluacionDTO dto) {
        EvaluacionDomain domain = new EvaluacionDomain();
        domain.setId(dto.getId());
        domain.setEstado(dto.getEstado());
        domain.setNombre(dto.getNombre());
        domain.setTotalPunto(dto.getTotalPunto());
        domain.setIdEtapa(dto.getIdEtapa());

        return domain;
    }


    @Override
    @Transactional
    public EvaluacionDTO update(Integer id, EvaluacionDTO dto) {
        if (dto.getEstado() != null && dto.getIdEtapa() != null && dto.getNombre() != null && dto.getTotalPunto() != null) {
            return evaluacionDao.findById(id).map(evaluacionDomain -> {
                evaluacionDomain.setNombre(dto.getNombre());
                evaluacionDomain.setEstado(dto.getEstado());
                evaluacionDomain.setIdEtapa(dto.getIdEtapa());
                evaluacionDomain.setTotalPunto(dto.getTotalPunto());
                dto.setId(evaluacionDomain.getId());
                return save(dto);
            }).orElse(null) != null ? dto : null;
        }
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return evaluacionDao.findById(id).map(evaluacionDomain -> {
            EvaluacionDTO dto = convertDomainToDto(evaluacionDomain);
            if (dto.getEstado()) {
                dto.setEstado(false);
                save(dto);
                return true;
            } else {
                return false;
            }
        }).orElse(false);
    }
}
