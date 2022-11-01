package com.fiuni.apirest.PlanillaCalificacionAPI.service.listaMateria;


import com.fiuni.apirest.PlanillaCalificacionAPI.dao.listaMateria.IListaMateriaDao;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaMateria.ListaMateriaDTO;
import com.fiuni.apirest.PlanillaCalificacionAPI.dto.listaMateria.ListaMateriaResult;
import com.fiuni.apirest.PlanillaCalificacionAPI.service.base.BaseServiceImpl;
import com.library.domainLibrary.domain.listaMateria.ListaMateriaDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public class ListaMateriaServiceImpl extends BaseServiceImpl<ListaMateriaDTO, ListaMateriaDomain, ListaMateriaResult> implements IListaMateriaService {
    @Autowired
    private IListaMateriaDao listaMateriaDao;


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
    public ListaMateriaDTO save(ListaMateriaDTO dto) {
        return convertDomainToDto(listaMateriaDao.save(convertDtoToDomain(dto)));
    }

    @Override
    public ListaMateriaDTO getById(Integer id) {
        return convertDomainToDto(listaMateriaDao.findById(id).orElse(null));
    }

    @Override
    public ListaMateriaResult getAll(Pageable pageable) {
        return new ListaMateriaResult(listaMateriaDao.findAll(pageable).map(p -> convertDomainToDto(p)).toList());
    }

    @Override
    @Transactional
    public ListaMateriaDTO update(Integer id, ListaMateriaDTO dto) {
        if (dto.getEstado() != null && dto.getIdMateria() != null && dto.getIdClase() != null && dto.getIdProfesor() != null) {
            return listaMateriaDao.findById(id).map(domain -> {
                domain.setEstado(dto.getEstado());
                domain.setIdMateria(dto.getIdMateria());
                domain.setIdClase(dto.getIdClase());
                domain.setIdProfesor(dto.getIdProfesor());
                dto.setId(domain.getId());
                return save(dto);
            }).orElse(null) != null ? dto : null;
        }
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return listaMateriaDao.delete(id);
    }
}
