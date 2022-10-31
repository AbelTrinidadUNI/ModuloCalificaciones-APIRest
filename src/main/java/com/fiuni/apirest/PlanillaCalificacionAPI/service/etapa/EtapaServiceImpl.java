package com.fiuni.apirest.PlanillaCalificacionAPI.service.etapa;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.etapa.IEtapaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.domain.etapa.EtapaDomain;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
    public EtapaDTO save(EtapaDTO dto) {
        dto.setEstado(dto.getEstado() == null ? true : dto.getEstado());
        return convertDomainToDto(etapaDao.save(convertDtoToDomain(dto)));
    }


    @Override
    @Transactional
    public EtapaDTO getById(Integer id) {
        Optional<EtapaDomain> etapaDomainOp = etapaDao.findById(id);
        return etapaDomainOp.map(etapa -> {
            return convertDomainToDto(etapa);
        }).orElse(null);

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

    @Override
    @Transactional
    public EtapaResult getAll(Pageable pageable) {
        EtapaResult result = new EtapaResult(etapaDao.findAll(pageable).map(etapa -> {
            return convertDomainToDto(etapa);
        }).toList());

        return result;
    }

    @Override
    @Transactional
    public EtapaDTO update(Integer id, EtapaDTO dto) {
        if (dto.getEstado() != null && dto.getDescripcion() != null) {
            return etapaDao.findById(id).map(etapaDomain -> {
                etapaDomain.setDescripcion(dto.getDescripcion());
                etapaDomain.setEstado(dto.getEstado());
                dto.setId(etapaDomain.getId());
                return save(dto);
            }).orElse(null) != null ? dto : null;
        }
        return null;
    }

    @Override
    @Transactional
    public Boolean delete(Integer id) {
        return etapaDao.findById(id).map(etapaDomain -> {
            EtapaDTO dto = convertDomainToDto(etapaDomain);
            if (dto.getEstado()) {
                dto.setEstado(false);
                save(dto);
                return true;
            } else {
                return false;
            }
        }).orElse(false);

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
