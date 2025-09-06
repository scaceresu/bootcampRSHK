package x4mv.userapp.userappbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import x4mv.userapp.userappbackend.models.RolModel;

@Repository
public interface RolRepository extends CrudRepository <RolModel, Integer>{

    
} 
    
