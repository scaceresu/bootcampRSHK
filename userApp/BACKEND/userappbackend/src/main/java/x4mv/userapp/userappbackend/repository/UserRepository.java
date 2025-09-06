package x4mv.userapp.userappbackend.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import x4mv.userapp.userappbackend.models.UserInfo;

@Repository
public interface UserRepository extends CrudRepository <UserInfo, Integer>{

    Optional<UserInfo> findByCorreo(String correo); 
} 
