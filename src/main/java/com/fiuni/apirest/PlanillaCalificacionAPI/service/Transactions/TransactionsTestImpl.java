package com.fiuni.apirest.PlanillaCalificacionAPI.service.Transactions;

import com.fiuni.apirest.PlanillaCalificacionAPI.dao.etapa.IEtapaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dao.evaluacion.IEvaluacionDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaListEvalDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.evaluacion.EvaluacionEtapaListDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.library.domainLibrary.domain.etapa.EtapaDomain;
import com.library.domainLibrary.domain.evaluacion.EvaluacionDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionsTestImpl extends BaseServiceImpl<EtapaDTO, EtapaDomain, EtapaResult> implements ITransactionsTest {

    @Autowired
    private IEtapaDao etapaDao;

    @Autowired
    private IEvaluacionDao evalDao;

    @Override
    public EtapaDTO update(Integer id, EtapaDTO dto) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    @Override
    public Integer deleteAbs(Integer id) {
        return null;
    }


    @Scheduled(fixedDelay = 10000)
    public void despertar() {
        etapaDao.getAllWithoutUse().forEach(e -> System.out.println("ID ETAPA: " + e.getId()) );
        System.out.println("\n\n\n¡Datos Obtenidos!\n\n\n");
    }


    @Modifying(clearAutomatically = true, flushAutomatically = true)
    //@Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Boolean saveAllRequired(EtapaListEvalDTO dto) {
        //Mapear a un domain
        final EtapaDomain domain = new EtapaDomain();
        //domain.setId(dto.getId());
        domain.setDescripcion(dto.getDescripcion());
        domain.setEstado(dto.getEstado());
        final EtapaDomain responseDomain = etapaDao.save(domain);

        List<EvaluacionDomain>  evaluacionesDomains = convertEvaluacionesDtosADomainsRequired(responseDomain, dto);

        domain.setEvaluaciones(evaluacionesDomains);
        //etapaDao.save(domain);

        return true;
    }

    @Override
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    //@Transactional(propagation = Propagation.REQUIRED)
    public Boolean saveAllSupports(EtapaListEvalDTO dto) {
        //Mapear a un domain
        final EtapaDomain domain = new EtapaDomain();
        domain.setDescripcion(dto.getDescripcion());
        domain.setEstado(dto.getEstado());
        final EtapaDomain responseDomain = etapaDao.save(domain);

        List<EvaluacionDomain>  evaluacionesDomains = convertEvaluacionesDtosADomainsSupports(responseDomain, dto);

        domain.setEvaluaciones(evaluacionesDomains);
        return true;
    }

    @Override
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    //@Transactional(propagation = Propagation.REQUIRED)
    public Boolean saveAllNotSupported(EtapaListEvalDTO dto) {
        //Mapear a un domain
        final EtapaDomain domain = new EtapaDomain();
        domain.setDescripcion(dto.getDescripcion());
        domain.setEstado(dto.getEstado());
        final EtapaDomain responseDomain = etapaDao.save(domain);

        List<EvaluacionDomain>  evaluacionesDomains = convertEvaluacionesDtosADomainsNoSupported(responseDomain, dto);

        domain.setEvaluaciones(evaluacionesDomains);
        return true;
    }


    @Override
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    //@Transactional(propagation = Propagation.REQUIRED)
    public Boolean saveAllRequiresNew(EtapaListEvalDTO dto) {
        //Mapear a un domain
        final EtapaDomain domain = new EtapaDomain();
        domain.setDescripcion(dto.getDescripcion());
        domain.setEstado(dto.getEstado());
        final EtapaDomain responseDomain = etapaDao.save(domain);

        List<EvaluacionDomain>  evaluacionesDomains = convertEvaluacionesDtosADomainsRequiresNew(responseDomain, dto);

        domain.setEvaluaciones(evaluacionesDomains);
        return true;
    }




    @Override
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    //@Transactional(propagation = Propagation.REQUIRED)
    public Boolean saveAllNever(EtapaListEvalDTO dto) {
        //Mapear a un domain
        final EtapaDomain domain = new EtapaDomain();
        domain.setDescripcion(dto.getDescripcion());
        domain.setEstado(dto.getEstado());
        final EtapaDomain responseDomain = etapaDao.save(domain);

        List<EvaluacionDomain>  evaluacionesDomains = convertEvaluacionesDtosADomainsNever(responseDomain, dto);

        domain.setEvaluaciones(evaluacionesDomains);
        return true;
    }



    @Override
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    //@Transactional(propagation = Propagation.REQUIRED)
    public Boolean saveAllMandatory(EtapaListEvalDTO dto) {
        //Mapear a un domain
        final EtapaDomain domain = new EtapaDomain();
        domain.setDescripcion(dto.getDescripcion());
        domain.setEstado(dto.getEstado());
        final EtapaDomain responseDomain = etapaDao.save(domain);

        List<EvaluacionDomain>  evaluacionesDomains = convertEvaluacionesDtosADomainsMandatory(responseDomain, dto);

        domain.setEvaluaciones(evaluacionesDomains);
        return true;
    }




    @Transactional(propagation = Propagation.REQUIRED)
    public List<EvaluacionDomain> convertEvaluacionesDtosADomainsRequired(EtapaDomain domain, EtapaListEvalDTO dto){
        if(domain.getId() == null || domain.getId() <= 0){
            throw new RuntimeException("ERROR ID DE CABECERA IGUAL A: " + domain.getId());
        }
        final List<EvaluacionDomain> evaluacionesDomains = new ArrayList<>();
        System.out.println("El id de la cabecera es: " + domain.getId() + " la cantidad de evaluaciones es de: " + dto.getEvalauciones().size());
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

        return evaluacionesDomains;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<EvaluacionDomain> convertEvaluacionesDtosADomainsSupports(EtapaDomain domain, EtapaListEvalDTO dto){
        if(domain.getId() == null || domain.getId() <= 0){
            throw new RuntimeException("ERROR ID DE CABECERA IGUAL A: " + domain.getId());
        }
        final List<EvaluacionDomain> evaluacionesDomains = new ArrayList<>();
        System.out.println("El id de la cabecera es: " + domain.getId() + " la cantidad de evaluaciones es de: " + dto.getEvalauciones().size());
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

        return evaluacionesDomains;
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<EvaluacionDomain> convertEvaluacionesDtosADomainsNoSupported(EtapaDomain domain, EtapaListEvalDTO dto){
        if(domain.getId() == null || domain.getId() <= 0){
            throw new RuntimeException("ERROR ID DE CABECERA IGUAL A: " + domain.getId());
        }
        final List<EvaluacionDomain> evaluacionesDomains = new ArrayList<>();
        System.out.println("El id de la cabecera es: " + domain.getId() + " la cantidad de evaluaciones es de: " + dto.getEvalauciones().size());
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

        return evaluacionesDomains;
    }


    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<EvaluacionDomain> convertEvaluacionesDtosADomainsRequiresNew(EtapaDomain domain, EtapaListEvalDTO dto){
        if(domain.getId() == null || domain.getId() <= 0){
            throw new RuntimeException("ERROR ID DE CABECERA IGUAL A: " + domain.getId());
        }
        final List<EvaluacionDomain> evaluacionesDomains = new ArrayList<>();
        System.out.println("El id de la cabecera es: " + domain.getId() + " la cantidad de evaluaciones es de: " + dto.getEvalauciones().size());
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

        return evaluacionesDomains;
    }


    @Transactional(propagation = Propagation.NEVER)
    public List<EvaluacionDomain> convertEvaluacionesDtosADomainsNever(EtapaDomain domain, EtapaListEvalDTO dto){
        if(domain.getId() == null || domain.getId() <= 0){
            throw new RuntimeException("ERROR ID DE CABECERA IGUAL A: " + domain.getId());
        }
        final List<EvaluacionDomain> evaluacionesDomains = new ArrayList<>();
        System.out.println("El id de la cabecera es: " + domain.getId() + " la cantidad de evaluaciones es de: " + dto.getEvalauciones().size());
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

        return evaluacionesDomains;
    }


    @Transactional(propagation = Propagation.MANDATORY)
    public List<EvaluacionDomain> convertEvaluacionesDtosADomainsMandatory(EtapaDomain domain, EtapaListEvalDTO dto){
        if(domain.getId() == null || domain.getId() <= 0){
            throw new RuntimeException("ERROR ID DE CABECERA IGUAL A: " + domain.getId());
        }
        final List<EvaluacionDomain> evaluacionesDomains = new ArrayList<>();
        System.out.println("El id de la cabecera es: " + domain.getId() + " la cantidad de evaluaciones es de: " + dto.getEvalauciones().size());
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

        return evaluacionesDomains;
    }
















    @Override
    public EtapaDTO convertDomainToDto(EtapaDomain domain) {
        if (domain == null) {
            return null;
        }

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

    @Override
    public EtapaDTO save(EtapaDTO dto) throws Exception {
        try {
            EtapaDomain domain = convertDtoToDomain(dto);
            EtapaDomain domainResponse = etapaDao.save(domain);
            EtapaDTO response = convertDomainToDto(domainResponse);
            return response;
        }catch (Exception e){
            throw new RuntimeException("Rollback despues de un error al guardar una nueva etapa");
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public EtapaDTO getById(Integer id) throws Exception {


        Optional<EtapaDomain> domain = etapaDao.findById(id);
        if (domain.isPresent()) {
            EtapaDTO dto = convertDomainToDto(domain.get());

            return dto;

        } else {
            throw new RuntimeException("Rollback de transaccion  de lectura");
        }
    }



    @Override
    public EtapaResult getAll(Pageable pageable) throws Exception {
        return null;
    }
}
