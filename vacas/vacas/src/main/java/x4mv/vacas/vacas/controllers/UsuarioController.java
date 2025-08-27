package x4mv.vacas.vacas.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import x4mv.vacas.vacas.models.UsuarioModel;
import x4mv.vacas.vacas.services.UsuarioService;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/usuario")
public class UsuarioController {


    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    
    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model model) {
        model.addAttribute("usuario", new UsuarioModel());
        return "usuario/crear-usuario"; // Sin .html
    }
    @PostMapping("/crear")
    public String crearUsuario(
        @Valid @ModelAttribute("usuario") UsuarioModel usuario,
        BindingResult result,
        Model model,
        RedirectAttributes redirectAttributes
    ) {

        // 1️⃣ Errores de validación (@NotBlank, @Email, etc.)
        if (result.hasErrors()) {
            // Retornamos la misma vista con los errores y el objeto usuario
            model.addAttribute("usuario", usuario); // ⚠ Mantener datos en el formulario
            return "usuario/crear-usuario"; 
        }

        try {
            // 2️⃣ Guardar usuario y lanzar excepciones de negocio si algo falla
            usuarioService.guardarUsuario(usuario);

            // 3️⃣ Éxito: usar redirect + flash attribute
            redirectAttributes.addFlashAttribute("success", "Usuario creado exitosamente");
            return "redirect:/usuario/exito";

        } catch (Exception e) {
            // 4️⃣ Error de negocio: mostrar mensaje en la misma vista
            model.addAttribute("error", e.getMessage());
            model.addAttribute("usuario", usuario); // ⚠ Mantener datos ingresados
            return "usuario/crear-usuario";
        }
    }

    

    @GetMapping("/consultar")
    public String consultarUsuario(Model model) {

        Iterable<UsuarioModel> usuarios = usuarioService.mostrarUsuarios();
        // pasamos los datos para que thymeleaf los pueda usar
        model.addAttribute("usuarios", usuarios);
        return "usuario/consultar-usuario"; // Sin .html
    }



    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Optional<UsuarioModel> usuario = usuarioService.encontrarPorID(id);
        model.addAttribute("usuario", usuario);
        return "/usuario/editar-usuario"; 
    }

    @PostMapping("/editar")
    public String editarUsuario(@ModelAttribute("usuario") UsuarioModel usuario) {
        
        usuarioService.guardarUsuario(usuario);
        
        return "/usuario/editado-exito";
    }
    




    @GetMapping("/eliminar")
     public String mostrarFormularioEliminacion() {
        return "/usuario/eliminar-usuario"; 
    }

    @PostMapping("/eliminar")
    public String eliminarUsuario(@RequestParam("id_usuario") Long idUsuario){

        System.out.println("ID RECIBIDO ==> " + idUsuario);
        try {
            System.out.println("LLEGO EL DELETE");
            usuarioService.eliminarUsuario(idUsuario);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "usuario/eliminado-exito";
    }
    


    @GetMapping("/exito")
    public String exito() {
        return "usuario/exito"; // ✅ Página de éxito
    }
}