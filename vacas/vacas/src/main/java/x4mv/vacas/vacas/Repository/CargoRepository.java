package x4mv.vacas.vacas.Repository;
import org.springframework.stereotype.Repository;
import x4mv.vacas.vacas.models.CargoModel;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface CargoRepository extends CrudRepository <CargoModel, Long> {
    
}
