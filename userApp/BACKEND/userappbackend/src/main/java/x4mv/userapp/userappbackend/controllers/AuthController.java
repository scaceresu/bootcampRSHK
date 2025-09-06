package x4mv.userapp.userappbackend.controllers;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import x4mv.userapp.userappbackend.models.AuthResponseDto;
import x4mv.userapp.userappbackend.models.GetUserInfoDTO;
import x4mv.userapp.userappbackend.models.LoginDTO;
import x4mv.userapp.userappbackend.models.RegisterResponseDTO;
import x4mv.userapp.userappbackend.models.RegisterUserDTO;
import x4mv.userapp.userappbackend.models.UserModel;
import x4mv.userapp.userappbackend.security.UserAuthProvider;
import x4mv.userapp.userappbackend.service.UserService;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder; // 🔹 importante
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/api")
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthProvider userAuthProvider;
    private final PasswordEncoder passwordEncoder; // 🔹 inyectamos

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO login) {
        
        
        Optional<UserModel> user = userService.getUserByCorreo(login.getCorreo());

        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body(new ErrorDto("Usuario no encontrado"));
        }
        
        UserModel usuario = user.get();

        // Validar la contraseña 
        if (!passwordEncoder.matches(login.getContrasena(), usuario.getContrasena())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                                 .body(new ErrorDto("Contraseña incorrecta"));
        }

        // generar token
        String token = userAuthProvider.createToken(usuario.getCorreo());

        return ResponseEntity.ok(new AuthResponseDto(usuario, token));
    }

    

    @PostMapping("/registrar")
    public ResponseEntity<RegisterResponseDTO> registrar(@RequestBody RegisterUserDTO dto) {
        UserModel user = userService.registrarUsuario(dto);

        // Generar token con AuthProvider
        String token = userAuthProvider.createToken(user.getCorreo());

        // Crear DTO de respuesta
        RegisterResponseDTO response = new RegisterResponseDTO();
        response.setCorreo(user.getCorreo());
        response.setToken(token);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
