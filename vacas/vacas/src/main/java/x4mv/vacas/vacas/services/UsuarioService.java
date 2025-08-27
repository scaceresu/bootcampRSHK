package x4mv.vacas.vacas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import x4mv.vacas.vacas.Repository.UsuarioRepository;
import x4mv.vacas.vacas.models.UsuarioModel;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel guardarUsuario(UsuarioModel usuario){

        System.out.println("POST RECIBIDO");
        if(usuarioRepository.existsByNroCedula(usuario.getNroCedula())){
            throw new RuntimeException("El Ci ya esta registrado" + usuario.getNombre() + " " + usuario.getApellido() +" en la fecha: "+usuario.getFechaIngreso());
        }

        return usuarioRepository.save(usuario);

    } 

    public Iterable<UsuarioModel> mostrarUsuarios(){
        System.out.println("MOSTRANDO ==> USER");

        return usuarioRepository.findAll();
    }
}
