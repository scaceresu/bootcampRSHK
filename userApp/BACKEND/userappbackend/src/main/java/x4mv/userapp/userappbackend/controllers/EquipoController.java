package x4mv.userapp.userappbackend.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import x4mv.userapp.userappbackend.models.EquipoModel;
import x4mv.userapp.userappbackend.repository.EquipoRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class EquipoController {
    

    @Autowired
    private EquipoRepository cargoRepository;

    @GetMapping("/equipos")
    public Iterable<EquipoModel> getAllEquipos() {
        return cargoRepository.findAll(); 
    }
    


}
