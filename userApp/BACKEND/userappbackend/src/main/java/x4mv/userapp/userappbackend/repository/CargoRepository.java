package x4mv.userapp.userappbackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import x4mv.userapp.userappbackend.models.CargoModel;

@Repository
public interface CargoRepository extends CrudRepository <CargoModel, Integer> {
    
}
