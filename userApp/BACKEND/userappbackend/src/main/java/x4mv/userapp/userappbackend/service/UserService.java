package x4mv.userapp.userappbackend.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import x4mv.userapp.userappbackend.models.GetUserInfoDTO;
import x4mv.userapp.userappbackend.models.RegisterUserDTO;
import x4mv.userapp.userappbackend.models.UserModel;
import x4mv.userapp.userappbackend.repository.UserModelRepository;
import x4mv.userapp.userappbackend.repository.UserRepository;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserModelRepository userModelRepository;

    UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Guarda un usuario. Hashea la contraseña si es necesario
     * y calcula los días de vacaciones restantes antes de guardar.
     */
    public void saveUser(UserModel user) {

        System.out.println("SALVANDOOOOO");


    // Verificar si ya existe usuario con ese correo
    if (userModelRepository.findByCorreo(user.getCorreo()).isPresent()) {
        throw new RuntimeException("Ya existe un usuario con ese nro de cedula");
    }

    // Hashea contraseña solo si no está hasheada
    if (user.getContrasena() != null && !user.getContrasena().startsWith("$2a$")) {
        user.setContrasena(encoder.encode(user.getContrasena()));
    }

    userModelRepository.save(user);
}


    /**
     * Obtiene información de usuario para DTO
     */
    public Optional<GetUserInfoDTO> getUserInfo(Integer id) {
        return userRepository.findById(id).map(user -> {
            GetUserInfoDTO dto = new GetUserInfoDTO();
            dto.setNombre(user.getNombre());
            dto.setApellido(user.getApellido());
            dto.setEquipoNombre(user.getEquipo() != null ? user.getEquipo().getNombre() : "");
            dto.setCargoNombre(user.getCargo() != null ? user.getCargo().getNombre() : "");
            dto.setRolNombre(user.getRol() != null ? user.getRol().getNombre() : "");
            dto.setDiasVacaciones(user.getDiasVacaciones());
            dto.setDiasVacaionesRestante(user.getDiasVacaionesRestante()); // corregido typo
            dto.setAntiguedad(user.getAntiguedad());
            dto.setNroCedula(user.getNroCedula());
            return dto;
        });
    }

    // Get userInfo by Correo
    public Optional<GetUserInfoDTO> getUserInfoByCorreo (String correo){
        return userRepository.findByCorreo(correo).map(user -> {
            GetUserInfoDTO dto = new GetUserInfoDTO();
            dto.setNombre(user.getNombre());
            dto.setApellido(user.getApellido());
            dto.setEquipoNombre(user.getEquipo() != null ? user.getEquipo().getNombre() : "");
            dto.setCargoNombre(user.getCargo() != null ? user.getCargo().getNombre() : "");
            dto.setRolNombre(user.getRol() != null ? user.getRol().getNombre() : "");
            dto.setDiasVacaciones(user.getDiasVacaciones());
            dto.setDiasVacaionesRestante(user.getDiasVacaionesRestante()); // corregido typo
            dto.setAntiguedad(user.getAntiguedad());
            dto.setNroCedula(user.getNroCedula());
            dto.setCorreo(user.getCorreo());
            return dto;
        });
    }
    /**
     * Obtiene un usuario completo
     */
    public Optional<UserModel> getUser(Integer id) {
        return userModelRepository.findById(id);
    }

    // Obtener usuario por el nroCedula
    public Optional<UserModel> getUserByNroCedula(Integer nroCedula){
        return userModelRepository.findByNroCedula(nroCedula);
    }


    public Optional<UserModel> getUserByCorreo(String correo){
        return userModelRepository.findByCorreo(correo);
    }

    public UserModel registrarUsuario(RegisterUserDTO registerDTO){

        // 1️⃣ Mapear DTO a entidad
        UserModel user = new UserModel();
        user.setNroCedula(registerDTO.getNroCedula());
        user.setNombre(registerDTO.getNombre());
        user.setApellido(registerDTO.getApellido());
        user.setCorreo(registerDTO.getCorreo());
        user.setTelefono(registerDTO.getTelefono());
        user.setContrasena(passwordEncoder.encode(registerDTO.getContrasena())); // si encriptas
        user.setIdRol(registerDTO.getIdRol());
        user.setIdEquipo(registerDTO.getIdEquipo());
        user.setIdCargo(registerDTO.getIdCargo());
        user.setEstado(true); // ejemplo
        user.setFechaIngreso(registerDTO.getFechaIngreso());
        user.setFechaNacimiento(registerDTO.getFechaNacimiento());
        user.setDiasVacaciones(registerDTO.getDiasVacaciones()); // valor por defecto
        user.setRequiereCambioContrasena(registerDTO.isRequiereCambioContrasena());

        // 2️⃣ Guardar la entidad
        UserModel savedUser = userModelRepository.save(user);

            // 3️⃣ Devolver la entidad guardada
        return savedUser;

        
    }
}
