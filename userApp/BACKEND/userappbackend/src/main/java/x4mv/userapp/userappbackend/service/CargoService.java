package x4mv.userapp.userappbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import x4mv.userapp.userappbackend.models.CargoModel;
import x4mv.userapp.userappbackend.repository.CargoRepository;

@Service
public class CargoService {
    
    @Autowired
    private CargoRepository cargoRepository;


    public Iterable<CargoModel> getAllCargos(){
        return cargoRepository.findAll();
    }



}
