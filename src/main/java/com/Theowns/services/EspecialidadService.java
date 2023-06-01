package com.Theowns.services;

import com.Theowns.models.EspecialidadModel;
import com.Theowns.repositories.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {
    @Autowired
    EspecialidadRepository especialidadRepository;

    public List<EspecialidadModel> findEspecialidadesByConductorId(Long id){
        return especialidadRepository.findAll();
    }
}
