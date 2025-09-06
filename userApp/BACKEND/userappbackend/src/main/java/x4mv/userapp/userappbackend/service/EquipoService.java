package x4mv.userapp.userappbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import x4mv.userapp.userappbackend.models.EquipoModel;
import x4mv.userapp.userappbackend.repository.EquipoRepository;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public Iterable<EquipoModel> getAllEquipos(){
        return equipoRepository.findAll();
    }
    
}
