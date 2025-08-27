package x4mv.vacas.vacas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import x4mv.vacas.vacas.Repository.UsuarioRepository;
import x4mv.vacas.vacas.models.UsuarioModel;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel guardarUsuario(UsuarioModel usuario) {
    System.out.println("POST RECIBIDO");

    // Buscar si existe otro usuario con el mismo nroCedula
    Optional<UsuarioModel> existente = usuarioRepository.findByNroCedula(usuario.getNroCedula());
    
    if (existente.isPresent() && !existente.get().getId().equals(usuario.getId())) {
        // Si existe otro usuario con ese CI y no es el mismo que estamos editando
        throw new RuntimeException(
            "El CI ya está registrado: " + usuario.getNombre() + " " + usuario.getApellido() +
            " en la fecha: " + usuario.getFechaIngreso()
        );
    }

    return usuarioRepository.save(usuario);
}


    public Iterable<UsuarioModel> mostrarUsuarios(){
        System.out.println("MOSTRANDO ==> USER");

        return usuarioRepository.findAll();
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
