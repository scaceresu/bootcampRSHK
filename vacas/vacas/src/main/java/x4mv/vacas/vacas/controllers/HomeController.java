package x4mv.vacas.vacas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import x4mv.vacas.vacas.services.UsuarioService;

import org.springframework.ui.Model;



@Controller
public class HomeController {

   
     private final UsuarioService usuarioService;

     public HomeController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("usuarios", usuarioService.mostrarUsuarios());
        model.addAttribute("equipos", usuarioService.listarEquipos());
        return "index";
    }
    
    
}
