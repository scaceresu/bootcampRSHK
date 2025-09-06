package x4mv.userapp.userappbackend.repository;

import org.springframework.data.repository.CrudRepository;

import x4mv.userapp.userappbackend.models.UserModel;
import java.util.Optional;




public interface UserModelRepository extends CrudRepository <UserModel, Integer>{
   
    Optional<UserModel> findByCorreo(String correo);
    Optional<UserModel> findByNroCedula(int nroCedula);
    
}
