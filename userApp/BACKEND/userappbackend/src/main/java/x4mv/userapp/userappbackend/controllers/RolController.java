package x4mv.userapp.userappbackend.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import x4mv.userapp.userappbackend.models.RolModel;
import x4mv.userapp.userappbackend.repository.RolRepository;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class RolController {
    

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/roles")
    public Iterable<RolModel> getAllRoles() {

        return rolRepository.findAll(); 

    }
    


}
