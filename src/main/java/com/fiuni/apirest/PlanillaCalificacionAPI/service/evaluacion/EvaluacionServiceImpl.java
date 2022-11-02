package com.fiuni.apirest.PlanillaCalificacionAPI.service.evaluacion;

import com.fiuni.apirest.PlanillaCalificacionAPI.dao.etapa.IEtapaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dao.evaluacion.IEvaluacionDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.library.domainLibrary.domain.evaluacion.EvaluacionDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EvaluacionServiceImpl extends BaseServiceImpl<EvaluacionDTO, EvaluacionDomain, EvaluacionResult> implements IEvaluacionService {
    @Autowired(required = true)
    private IEvaluacionDao evaluacionDao;
    @Autowired(required = true)
    private IEtapaDao etapaDao;

    @Override
    @Transactional
    public ResponseEntity<EvaluacionDTO> save(EvaluacionDTO dto) {
        dto.setEstado(dto.getEstado() == null || dto.getEstado());

        EvaluacionDTO response = convertDomainToDto(evaluacionDao.save(convertDtoToDomain(dto)));

        return response != null ? new ResponseEntity<EvaluacionDTO>(response, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }


    @Override
    @Transactional
    public ResponseEntity<EvaluacionDTO> getById(Integer id) {
        EvaluacionDTO response = evaluacionDao.findById(id).map(evaluacionDomain -> convertDomainToDto(evaluacionDomain)).orElse(null);

        return response != null ? new ResponseEntity<EvaluacionDTO>(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public ResponseEntity<EvaluacionResult> getAll(Pageable pageable) {
        EvaluacionResult response = new EvaluacionResult(evaluacionDao.findAll(pageable).map(evaluacion -> {
            return convertDomainToDto(evaluacion);
        }).toList());

        return response != null ? new ResponseEntity(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @Override
    @Transactional
    public ResponseEntity<EvaluacionDTO> update(Integer id, EvaluacionDTO dto) {
        if (dto.getEstado() != null && dto.getIdEtapa() != null && dto.getNombre() != null && dto.getTotalPunto() != null) {
            EvaluacionDTO response = evaluacionDao.findById(id).map(evaluacionDomain -> {
                evaluacionDomain.setNombre(dto.getNombre());
                evaluacionDomain.setEstado(dto.getEstado());
                evaluacionDomain.setIdEtapa(dto.getIdEtapa());
                evaluacionDomain.setTotalPunto(dto.getTotalPunto());
                dto.setId(evaluacionDomain.getId());
                return save(dto);
            }).orElse(null).getBody();
            return response != null ? new ResponseEntity<EvaluacionDTO>(HttpStatus.NO_CONTENT)
                    : new ResponseEntity<>(HttpStatus.CONFLICT);

        }
        return new ResponseEntity<EvaluacionDTO>(HttpStatus.BAD_REQUEST);
    }

    @Override
    @Transactional
    public ResponseEntity<Boolean> delete(Integer id) {
        Boolean response = evaluacionDao.findById(id).map(evaluacionDomain -> {
            EvaluacionDTO dto = convertDomainToDto(evaluacionDomain);
            if (dto.getEstado()) {
                dto.setEstado(false);
                save(dto);
                return true;
            } else {
                return false;
            }
        }).orElse(false);

        return new ResponseEntity<Boolean>(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
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


}
