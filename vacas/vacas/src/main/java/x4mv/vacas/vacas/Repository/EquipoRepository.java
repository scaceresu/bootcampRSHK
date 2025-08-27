package x4mv.vacas.vacas.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import x4mv.vacas.vacas.models.EquipoModel;



@Repository
public interface EquipoRepository extends CrudRepository <EquipoModel, Long>{

    
} 
    


