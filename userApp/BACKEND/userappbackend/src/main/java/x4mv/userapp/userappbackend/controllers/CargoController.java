package x4mv.userapp.userappbackend.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import x4mv.userapp.userappbackend.models.CargoModel;
import x4mv.userapp.userappbackend.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class CargoController {

    @Autowired
    private CargoRepository cargoRepository;
    

    @GetMapping("cargos")
    public Iterable<CargoModel> getAllEquipos() {
        return cargoRepository.findAll();
    }
    

}
