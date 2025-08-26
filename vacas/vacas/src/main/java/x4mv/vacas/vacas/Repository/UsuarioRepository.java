package x4mv.vacas.vacas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import x4mv.vacas.vacas.models.UsuarioModel;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

    List<UsuarioModel> findByNombre(String nombre);
    boolean existsByNroCedula(int nro_cedula);
    
}
