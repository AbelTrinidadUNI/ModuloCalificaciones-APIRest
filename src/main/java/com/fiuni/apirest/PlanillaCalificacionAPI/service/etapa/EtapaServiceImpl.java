package com.fiuni.apirest.PlanillaCalificacionAPI.service.etapa;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.etapa.IEtapaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.library.domainLibrary.domain.etapa.EtapaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class EtapaServiceImpl extends BaseServiceImpl<EtapaDTO, EtapaDomain, EtapaResult> implements IEtapaService {
    @Autowired
    private IEtapaDao etapaDao;


    @Override
    @Transactional
    public ResponseEntity<EtapaDTO> save(EtapaDTO dto) {
        dto.setEstado(dto.getEstado() == null ? true : dto.getEstado());
        EtapaDTO response = convertDomainToDto(etapaDao.save(convertDtoToDomain(dto)));
        return response != null ? new ResponseEntity<EtapaDTO>(response, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.CONFLICT);
    }


    @Override
    @Transactional
    public ResponseEntity<EtapaDTO> getById(Integer id) {
        Optional<EtapaDomain> etapaDomainOp = etapaDao.findById(id);
        EtapaDTO response = etapaDomainOp.map(etapa -> {
            return convertDomainToDto(etapa);
        }).orElse(null);

        return response != null ? new ResponseEntity(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @Override
    @Transactional
    public ResponseEntity<EtapaResult> getAll(Pageable pageable) {
        EtapaResult result = new EtapaResult(etapaDao.findAll(pageable).map(etapa -> {
            return convertDomainToDto(etapa);
        }).toList());

        return result != null ? new ResponseEntity<EtapaResult>(result, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public ResponseEntity<EtapaDTO> update(Integer id, EtapaDTO dto) {

        if (dto.getEstado() != null && dto.getDescripcion() != null) {
            EtapaDTO etapaActualizada = etapaDao.findById(id).map(etapaDomain -> {
                etapaDomain.setDescripcion(dto.getDescripcion());
                etapaDomain.setEstado(dto.getEstado());
                dto.setId(etapaDomain.getId());
                return save(dto);
            }).orElse(null).getBody();
            return etapaActualizada != null ? new ResponseEntity<EtapaDTO>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<EtapaDTO>(HttpStatus.BAD_REQUEST);
    }

    @Override
    @Transactional
    public ResponseEntity<Boolean> delete(Integer id) {
        Boolean response = etapaDao.findById(id).map(etapaDomain -> {
            EtapaDTO dto = convertDomainToDto(etapaDomain);
            if (dto.getEstado()) {
                dto.setEstado(false);
                save(dto);
                return true;
            } else {
                return false;
            }
        }).orElse(null);
        return new ResponseEntity<Boolean>(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public ResponseEntity<Integer> deleteAbs(Integer id) {
        Integer response = etapaDao.deleteAbsolut(id);
        return new ResponseEntity<Integer>(response, response > 0 ? HttpStatus.OK : HttpStatus.METHOD_NOT_ALLOWED);//ResponseEntity.etapaDao.deleteAbsolut(id);
    }


    @Override
    protected EtapaDTO convertDomainToDto(EtapaDomain domain) {
        EtapaDTO dto = new EtapaDTO();
        dto.setId(domain.getId());
        dto.setDescripcion(domain.getDescripcion());
        dto.setEstado(domain.getEstado());
        return dto;
    }

    @Override
    protected EtapaDomain convertDtoToDomain(EtapaDTO dto) {
        EtapaDomain dom = new EtapaDomain();
        dom.setId(dto.getId());
        dom.setDescripcion(dto.getDescripcion());
        dom.setEstado(dto.getEstado());

        return dom;
    }

    /*@Override
    @Transactional
    public List<EtapaDTO> getAlls(Pageable pageable) {
        EtapaResult result = new EtapaResult(etapaDao.findAll(pageable).map(etapa -> {
            return convertDomainToDto(etapa);
        }).toList());

        return result.getLista();

    }*/
}
