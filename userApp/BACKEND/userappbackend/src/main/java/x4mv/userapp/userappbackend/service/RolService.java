package x4mv.userapp.userappbackend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import x4mv.userapp.userappbackend.models.RolModel;
import x4mv.userapp.userappbackend.repository.RolRepository;

@Service
public class RolService {
    

    @Autowired
    private RolRepository rolRepository;


    public Iterable<RolModel> getAllRoles(){
        return rolRepository.findAll();
    }

    
}
