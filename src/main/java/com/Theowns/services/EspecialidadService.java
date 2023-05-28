package com.Theowns.services;

import com.Theowns.models.ConductorModel;
import com.Theowns.models.EspecialidadModel;
import com.Theowns.repositories.EspecialidadRepository;
import com.Theowns.services.exceptions.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {

    @Autowired
    EspecialidadRepository especialidadRepository;
     public List<EspecialidadModel> findAllById(long id){

         return especialidadRepository.findAllById(id);
     }

    public EspecialidadModel save(EspecialidadModel especialidad) throws DuplicateException {
        if (especialidadRepository.existsByMecanicoId(especialidad.getMecanico()) {
            throw new DuplicateException("La especialidad "+ especialidad.getMecanico()+" ya está registrada");
        }
        especialidadService.save(especialidad.getMecanico());
        return EspecialidadRepository.save(especialidad);
    }

}
