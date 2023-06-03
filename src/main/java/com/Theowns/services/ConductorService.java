package com.Theowns.services;

import com.Theowns.DTO.PersonaDTO;
import com.Theowns.models.ConductorModel;
import com.Theowns.repositories.ConductorRepository;
import com.Theowns.services.exceptions.DuplicateException;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConductorService {
    @Autowired
    ConductorRepository conductorRepository;
    @Autowired
    UserService userService;

    public List<PersonaDTO> getAll() {

        List<ConductorModel> conductores = conductorRepository.findAll();
        List<PersonaDTO> conductorResponse = new ArrayList<>();
        for (ConductorModel conductor : conductores) {
            PersonaDTO conductorDAO = new PersonaDTO(conductor.getId(),conductor.getCedula(),conductor.getNombre(),conductor.getApellido(),conductor.getDireccion(), conductor.getTelefono());
            conductorResponse.add(conductorDAO);
        }
        return conductorResponse;
    }

    public PersonaDTO getOne(Long id) throws ExceptionObjectNotFound {
        ConductorModel conductor = conductorRepository.findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Conductor con id "+ id+ " no encontrado"));
        return new PersonaDTO(conductor.getId(),conductor.getCedula(),conductor.getNombre(),conductor.getApellido(),conductor.getDireccion(), conductor.getTelefono());
    }

    public ConductorModel getOneConductor(Long id) throws ExceptionObjectNotFound {
        return conductorRepository.findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Conductor con id "+ id+ " no encontrado"));
    }

    public ConductorModel save(ConductorModel conductor) throws DuplicateException {
        if (conductorRepository.existsByCedula(conductor.getCedula())) {
            throw new DuplicateException("La cedula "+ conductor.getCedula()+" ya está registrada");
        }
        userService.save(conductor.getUser());
        return conductorRepository.save(conductor);
    }

    public PersonaDTO update(Long id, ConductorModel conductorNuevo) throws ExceptionObjectNotFound {
        ConductorModel conductor = conductorRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Conductor con id "+ id +" no encontrado"));

        conductor.setDireccion(conductorNuevo.getDireccion());
        conductor.setNombre(conductorNuevo.getNombre());
        conductor.setApellido(conductorNuevo.getApellido());
        conductor.setTelefono(conductorNuevo.getTelefono());

        conductorRepository.save(conductor);
        return  new PersonaDTO(conductor.getId(),conductor.getCedula(),conductor.getNombre(),conductor.getApellido(),conductor.getDireccion(), conductor.getTelefono());

    }

    public String delete(Long id) throws ExceptionObjectNotFound {
        ConductorModel conductor = conductorRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Conductor con id "+ id +" no encontrado"));

        conductorRepository.delete(conductor);
        return "Conductor con ID " + id + " eliminado satisfactoriamente";

    }
}
