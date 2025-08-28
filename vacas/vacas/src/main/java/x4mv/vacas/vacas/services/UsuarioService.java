package x4mv.vacas.vacas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import x4mv.vacas.vacas.Repository.CargoRepository;
import x4mv.vacas.vacas.Repository.EquipoRepository;
import x4mv.vacas.vacas.Repository.RolRepository;
import x4mv.vacas.vacas.Repository.UsuarioRepository;
import x4mv.vacas.vacas.models.CargoModel;
import x4mv.vacas.vacas.models.EquipoModel;
import x4mv.vacas.vacas.models.RolModel;
import x4mv.vacas.vacas.models.UsuarioModel;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private RolRepository rolRepository;

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
    System.out.println("POST RECIBIDO");

        // Buscar si existe otro usuario con el mismo nroCedula
        Optional<UsuarioModel> existente = usuarioRepository.findByNroCedula(usuario.getNroCedula());
        
        if (existente.isPresent() && !existente.get().getId().equals(usuario.getId())) {
            UsuarioModel repetido = existente.get(); // el que ya existe en BD
            
            throw new RuntimeException(
                "El CI ya está registrado para: " + repetido.getNombre() + " " + repetido.getApellido() +
                " (Ingreso: " + repetido.getFechaIngreso() + ")"
            );
        }



        return usuarioRepository.save(usuario);
    }


    public Iterable<UsuarioModel> mostrarUsuarios(){
        System.out.println("MOSTRANDO ==> USER");

        return usuarioRepository.findAll();
    }

    public Iterable<EquipoModel> listarEquipos(){
        return equipoRepository.findAll();
    }

    public Iterable<CargoModel> listarCargos(){
        return cargoRepository.findAll();
    }

    public Iterable<RolModel> listarRoles(){
        return rolRepository.findAll();
    }


    public Iterable<UsuarioModel> mostrarPorEquipo(Long idEquipo){
        return usuarioRepository.findByIdEquipo(idEquipo);
    }

    public void eliminarUsuario(Long idUsuario){

        usuarioRepository.deleteById(idUsuario);

    }

    public Optional<UsuarioModel >encontrarPorID(Long idUsuario){

        return usuarioRepository.findById(idUsuario);
    }

    public void editarUsuario(UsuarioModel usuario){
        usuarioRepository.save(usuario);
    }

}
