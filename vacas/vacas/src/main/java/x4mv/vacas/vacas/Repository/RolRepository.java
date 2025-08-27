package x4mv.vacas.vacas.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import x4mv.vacas.vacas.models.RolModel;

@Repository
public interface RolRepository extends CrudRepository <RolModel, Long>{
    
}
