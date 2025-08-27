package x4mv.vacas.vacas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import x4mv.vacas.vacas.models.UsuarioModel;
import x4mv.vacas.vacas.services.UsuarioService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



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
        @Valid @ModelAttribute("usuario") UsuarioModel usuario, // ✅ Agregar @Valid y nombre del atributo
        BindingResult result,
        Model model,
        RedirectAttributes redirectAttributes
    ) {

        if(result.hasErrors()){
            System.out.println(result);
            return "/usuario/crear-usuario"; // ✅ Devolver la misma vista con errores
        }

        try {
            usuarioService.guardarUsuario(usuario); // ✅ Debe ser guardarUsuario, no guardarCliente
            redirectAttributes.addFlashAttribute("success", "Usuario creado exitosamente");
            return "redirect:/usuario/exito"; // ✅ Redirigir a una URL, no a un archivo
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "usuario/crear-usuario"; // ✅ Mantener en el formulario con error
        }
    }
    

    @GetMapping("/consultar")
    public String consultarUsuario(Model model) {

        Iterable<UsuarioModel> usuarios = usuarioService.mostrarUsuarios();

        // pasamos los datos para que thymeleaf los pueda usar
        model.addAttribute("usuarios", usuarios);
        return "usuario/consultar-usuario"; // Sin .html
    }



    @GetMapping("/editar")
    public String mostrarFormularioEdicion() {
        return "/usuario/editar-usuario"; 
    }


    @GetMapping("/eliminar")
     public String mostrarFormularioEliminacion() {
        return "/usuario/eliminar-usuario"; 
    }
    


    @GetMapping("/exito")
    public String exito() {
        return "usuario/exito"; // ✅ Página de éxito
    }
}