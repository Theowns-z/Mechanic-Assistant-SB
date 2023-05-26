package com.Theowns.services;

import com.Theowns.DAO.ConductorDAO;
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

    public List<ConductorDAO> getAll() {

        List<ConductorModel> conductores = conductorRepository.findAll();
        List<ConductorDAO> conductorResponse = new ArrayList<>();
        for (ConductorModel conductor : conductores) {
            ConductorDAO conductorDAO = new ConductorDAO(conductor.getId(),conductor.getNombre(),conductor.getApellido(),conductor.getDireccion(), conductor.getTelefono());
            conductorResponse.add(conductorDAO);
        }
        return conductorResponse;
    }

    public ConductorDAO getOne(Long id) throws ExceptionObjectNotFound {
        ConductorModel conductor = conductorRepository.findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Conductor con id "+ id+ " no encontrado"));
        return new ConductorDAO(conductor.getId(),conductor.getNombre(),conductor.getApellido(),conductor.getDireccion(), conductor.getTelefono());
    }

    public ConductorDAO update(Long id, ConductorModel conductorNuevo) throws ExceptionObjectNotFound {
        ConductorModel conductor = conductorRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Conductor con id "+ id +" no encontrado"));

        conductor.setApellido(conductorNuevo.getApellido());
        conductor.setDireccion(conductorNuevo.getDireccion());
        conductor.setNombre(conductorNuevo.getNombre());
        conductor.setTelefono(conductorNuevo.getTelefono());

        conductorRepository.save(conductor);
        return  new ConductorDAO(conductor.getId(),conductor.getNombre(),conductor.getApellido(),conductor.getDireccion(), conductor.getTelefono());

    }


    public ConductorModel save(ConductorModel conductor) throws DuplicateException {
        if (conductorRepository.existsByCedula(conductor.getCedula())) {
            throw new DuplicateException("La cedula "+ conductor.getCedula()+" ya está registrada");
        }
        userService.save(conductor.getUser());
        return conductorRepository.save(conductor);
    }

    public String delete(Long id) throws ExceptionObjectNotFound {
        ConductorModel conductor = conductorRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Conductor con id "+ id +" no encontrado"));

        conductorRepository.delete(conductor);
        return "Conductor con ID " + id + " eliminado satisfactoriamente";

    }
}
