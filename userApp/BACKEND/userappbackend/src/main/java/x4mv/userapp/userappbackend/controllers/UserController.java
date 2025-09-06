package x4mv.userapp.userappbackend.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import x4mv.userapp.userappbackend.models.GetUserInfoDTO;
import x4mv.userapp.userappbackend.models.UserModel;
import x4mv.userapp.userappbackend.repository.UserModelRepository;
import x4mv.userapp.userappbackend.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserModelRepository userModelRepository;
    private final UserService usuarioService;


    public UserController(UserModelRepository userModelRepository, UserService usuarioService,
    PasswordEncoder passwordEncoder ){
        this.userModelRepository = userModelRepository;
        this.usuarioService = usuarioService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/user-info/{correo}")
    public ResponseEntity<GetUserInfoDTO> getUserInfo(@PathVariable String correo) {
        return usuarioService.getUserInfoByCorreo(correo) // Optional<UserDTO>
                .map(ResponseEntity::ok)      // si existe, devuelve 200 con el DTO
                .orElseGet(() -> ResponseEntity.notFound().build()); // si no existe, 404
    }


    @GetMapping("/user-update/{correo}")
    public ResponseEntity<UserModel> getUpdateInfo(@PathVariable String correo) {
        return usuarioService.getUserByCorreo(correo) // Optional<UserDTO>
                .map(ResponseEntity::ok)      // si existe, devuelve 200 con el DTO
                .orElseGet(() -> ResponseEntity.notFound().build()); // si no existe, 404
    }
    
    @PutMapping("/user-update/{correo}")
    public ResponseEntity<UserModel> updateUser(
            @PathVariable String correo,
            @RequestBody UserModel updatedUser) {
        return userModelRepository.findByCorreo(correo)
                .map(user -> {
                    // Actualizamos los campos
                    user.setNombre(updatedUser.getNombre());
                    user.setApellido(updatedUser.getApellido());
                    user.setCorreo(updatedUser.getCorreo());
                    user.setTelefono(updatedUser.getTelefono());
                    user.setContrasena(passwordEncoder.encode(updatedUser.getContrasena()));
                    user.setEstado(updatedUser.getEstado());
                    user.setFechaIngreso(updatedUser.getFechaIngreso());
                    user.setFechaNacimiento(updatedUser.getFechaNacimiento());
                    user.setDiasVacaciones(updatedUser.getDiasVacaciones());
                    user.setDiasVacacionesRestantes(updatedUser.getDiasVacacionesRestantes());
                    user.calcularDiasVacacionesRestantes(updatedUser.getDiasVacaciones());

                    UserModel savedUser = userModelRepository.save(user);
                    return ResponseEntity.ok(savedUser);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    

    
}
