const daoCreator = (i, minusculas) => {
    
    return `package com.fiuni.apirest.PlanillaCalificacionAPI.dao.${minusculas};

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.library.domainLibrary.domain.${minusculas}.${i}Domain;


public class ${i} {
    @Repository
    public interface I${i}Dao extends CrudRepository<${i}Domain, Integer> {
        public Page<${i}Domain> findAll(Pageable pageable);

    }

}`

}

const daoGenerator = () => {
console.log(daoCreator(process.argv[3], process.argv[2]))
}
daoGenerator();