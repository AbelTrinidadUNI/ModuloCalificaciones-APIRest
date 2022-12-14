package com.fiuni.apirest.PlanillaCalificacionAPI.service.etapa;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.etapa.IEtapaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dao.evaluacion.IEvaluacionDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaListEvalDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionEtapaListDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.detallePN.IDetallePlanillaNotaService;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.evaluacion.IEvaluacionService;
import com.fiuni.apirest.PlanillaCalificacionAPI.utils.Settings;
import com.library.domainLibrary.domain.etapa.EtapaDomain;
import com.library.domainLibrary.domain.evaluacion.EvaluacionDomain;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EtapaServiceImpl extends BaseServiceImpl<EtapaDTO, EtapaDomain, EtapaResult> implements IEtapaService {
    @Autowired(required = true)
    private IEtapaDao etapaDao;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private IEvaluacionService evaluacionService;

    //@Autowired
    //private IDetallePlanillaNotaService detNotasService;

    @Override
    @Transactional
    public EtapaDTO save(EtapaDTO dto) {
        dto.setEstado(dto.getEstado() == null ? true : dto.getEstado());
        EtapaDomain domain = etapaDao.save(convertDtoToDomain(dto));
        EtapaDTO response = convertDomainToDto(domain);
        if(dto.getId() == null){
            cacheManager.getCache(Settings.CACHE_NAME).put("API_ETAPA_" + response.getId(), response);
        }

        return response;
    }


    @Override
    @Transactional
    @Cacheable(value = Settings.CACHE_NAME, key="'API_ETAPA_' + #id")
    public EtapaDTO getById(Integer id) {
        Optional<EtapaDomain> etapaDomainOp = etapaDao.findById(id);
        EtapaDTO response = etapaDomainOp.map(etapa -> {
            return convertDomainToDto(etapa);
        }).orElse(null);

        return response;
    }


    @Override
    @Transactional
    public EtapaResult getAll(Pageable pageable) {
        /*EtapaResult result = new EtapaResult(etapaDao.findAll(pageable).map(etapa -> {
            EtapaDTO dto = convertDomainToDto(etapa);
            cacheManager.getCache(Settings.CACHE_NAME).putIfAbsent("API_ETAPA_" + dto.getId(), dto);
            return dto;

        }).toList());
        */
        Page<EtapaDomain> page = etapaDao.getByEstadoTrue(pageable);

        EtapaResult response = new EtapaResult(etapaDao.getByEstadoTrue(pageable).map(etapa -> {
            EtapaDTO dto = convertDomainToDto(etapa);
            cacheManager.getCache(Settings.CACHE_NAME).putIfAbsent("API_ETAPA_" + dto.getId(), dto);
            return dto;

        }).toList());

        response.setTotalPages(page.getTotalPages());


        return response;
    }

    @Override
    @Transactional
    public EtapaDTO update(Integer id, EtapaDTO dto) {

        if (dto.getEstado() != null && dto.getDescripcion() != null) {
            EtapaDTO etapaActualizada = etapaDao.findById(id).map(etapaDomain -> {
                etapaDomain.setDescripcion(dto.getDescripcion());
                etapaDomain.setEstado(dto.getEstado());
                dto.setId(etapaDomain.getId());
                cacheManager.getCache(Settings.CACHE_NAME).evictIfPresent("API_ETAPA_" + id);
                return save(dto);
            }).orElse(null);

            if(etapaActualizada != null){
                cacheManager.getCache(Settings.CACHE_NAME).put("API_ETAPA_" + etapaActualizada.getId(), etapaActualizada);
            }
            return etapaActualizada;
        }
        return null;
    }


    @Override
    @Transactional
    public Boolean delete(Integer id) {
        Boolean response = etapaDao.findById(id).map(etapaDomain -> {
            EtapaDTO dto = convertDomainToDto(etapaDomain);
            if (dto.getEstado()) {
                dto.setEstado(false);
                EtapaDTO respuesta = save(dto);
                if(respuesta != null){
                    cacheManager.getCache(Settings.CACHE_NAME).evictIfPresent("API_ETAPA_" + id);
                }
                //se ocultan las evaluaciones asociadas a la etapa
                etapaDomain.getEvaluaciones().forEach(evaluacion -> {
                    evaluacionService.delete(evaluacion.getId());
                });
                return true;
            } else {
                return false;
            }
        }).orElse(null);
        return response;
    }

    @Override
    @Transactional
    public Integer deleteAbs(Integer id) {
        Integer response = etapaDao.deleteAbsolut(id);


        if(response != null && response > 0){
            cacheManager.getCache(Settings.CACHE_NAME).evictIfPresent("API_ETAPA_" + id);
        }
        return response;
    }

    @Autowired
    private IEvaluacionDao evalDao;

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Override
    public Boolean saveAll(EtapaListEvalDTO dto) {
        //Mapear a un domain
        final EtapaDomain domain = new EtapaDomain();
        //domain.setId(dto.getId());
        domain.setDescripcion(dto.getDescripcion());
        domain.setEstado(dto.getEstado());
        etapaDao.save(domain);

        //domain.setEvaluaciones(new ArrayList<EvaluacionDomain>());
        final List<EvaluacionDomain> evaluacionesDomains = new ArrayList<>();
        for(EvaluacionEtapaListDTO dtoE : dto.getEvalauciones()) {
            final EvaluacionDomain domainE = new EvaluacionDomain();

            domainE.setNombre(dtoE.getNombre());
            domainE.setTotalPunto(dtoE.getTotalPunto());
            domainE.setEstado(dtoE.getEstado());
            domainE.setIdEtapa(domain.getId());

            evaluacionesDomains.add(domainE);

            //domain.getEvaluaciones().add(domainE);
        }
        evalDao.saveAll(evaluacionesDomains);

        domain.setEvaluaciones(evaluacionesDomains);
        //etapaDao.save(domain);

        return true;
    }


    @Override
    public EtapaDTO convertDomainToDto(EtapaDomain domain) {
        EtapaDTO dto = new EtapaDTO();
        dto.setId(domain.getId());
        dto.setDescripcion(domain.getDescripcion());
        dto.setEstado(domain.getEstado());
        return dto;
    }

    @Override
    public EtapaDomain convertDtoToDomain(EtapaDTO dto) {
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
