package x4mv.vacas.vacas.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import x4mv.vacas.vacas.models.UsuarioModel;


@Repository
public interface UsuarioRepository extends CrudRepository <UsuarioModel, Long> {


    List<UsuarioModel> findByNombre(String nombre);
    boolean existsByNroCedula(int nro_cedula);
    
}
