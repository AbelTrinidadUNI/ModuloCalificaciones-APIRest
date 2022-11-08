package com.fiuni.apirest.PlanillaCalificacionAPI.service.listaMateria;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.listaMateria.IListaMateriaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dao.planillaNota.IPlanillaNotaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.etapa.EtapaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaMateria.ListaMateriaConAlumnosDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaMateria.ListaMateriaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaMateria.ListaMateriaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.library.domainLibrary.domain.listaMateria.ListaMateriaDomain;
import com.library.domainLibrary.domain.planillaNota.PlanillaNotaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

public class ListaMateriaServiceImpl extends BaseServiceImpl<ListaMateriaDTO, ListaMateriaDomain, ListaMateriaResult> implements IListaMateriaService {
    @Autowired
    private IListaMateriaDao listaMateriaDao;

    @Autowired
    private IPlanillaNotaDao planillaNotaDao;

    @Override
    protected ListaMateriaDTO convertDomainToDto(ListaMateriaDomain domain) {
        ListaMateriaDTO dto = new ListaMateriaDTO();

        dto.setId(domain.getId());
        dto.setEstado(domain.getEstado());
        dto.setIdMateria(domain.getIdMateria());
        dto.setIdClase(domain.getIdClase());
        dto.setIdProfesor(domain.getIdProfesor());

        return dto;
    }

    @Override
    protected ListaMateriaDomain convertDtoToDomain(ListaMateriaDTO dto) {
        ListaMateriaDomain domain = new ListaMateriaDomain();
        domain.setId(dto.getId());
        domain.setEstado(dto.getEstado());
        domain.setIdMateria(dto.getIdMateria());
        domain.setIdProfesor(dto.getIdProfesor());
        domain.setIdClase(dto.getIdClase());
        return domain;
    }

    @Override
    public ResponseEntity<ListaMateriaDTO> save(ListaMateriaDTO dto) {
        ListaMateriaDTO response = convertDomainToDto(listaMateriaDao.save(convertDtoToDomain(dto)));
        return response != null ? new ResponseEntity<ListaMateriaDTO>(response, HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @Override
    public ResponseEntity<ListaMateriaDTO> getById(Integer id) {
        ListaMateriaDTO response = convertDomainToDto(listaMateriaDao.findById(id).orElse(null));

        return response != null ? new ResponseEntity<ListaMateriaDTO>(response, HttpStatus.OK)
                : new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<ListaMateriaResult> getAll(Pageable pageable) {
        ListaMateriaResult response = new ListaMateriaResult(listaMateriaDao.findAll(pageable).map(p -> convertDomainToDto(p)).toList());

        return response != null ? new ResponseEntity<ListaMateriaResult>(response, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    @Transactional
    public ResponseEntity<ListaMateriaDTO> update(Integer id, ListaMateriaDTO dto) {
        if (dto.getEstado() != null && dto.getIdMateria() != null && dto.getIdClase() != null && dto.getIdProfesor() != null) {
            ListaMateriaDTO response = listaMateriaDao.findById(id).map(domain -> {
                domain.setEstado(dto.getEstado());
                domain.setIdMateria(dto.getIdMateria());
                domain.setIdClase(dto.getIdClase());
                domain.setIdProfesor(dto.getIdProfesor());
                dto.setId(domain.getId());
                return save(dto);
            }).orElse(null).getBody();
            return response != null ? new ResponseEntity<ListaMateriaDTO>(HttpStatus.NO_CONTENT) : new ResponseEntity<ListaMateriaDTO>(HttpStatus.CONFLICT);

        }
        return new ResponseEntity<ListaMateriaDTO>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Boolean> delete(Integer id) {
        Boolean response = listaMateriaDao.delete(id);
        return new ResponseEntity<Boolean>(response != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
