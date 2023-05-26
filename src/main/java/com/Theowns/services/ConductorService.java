package com.Theowns.services;

import com.Theowns.models.ConductorModel;
import com.Theowns.models.UserModel;
import com.Theowns.repositories.ConductorRepository;
import com.Theowns.repositories.UserRepository;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import com.Theowns.services.interfaces.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConductorService implements InterfaceService<ConductorModel> {
    @Autowired
    ConductorRepository conductorRepository;
    @Autowired
    UserService userService;

    @Override
    public List<ConductorModel> getAll() {
        return (List<ConductorModel>) conductorRepository.findAll();
    }

    @Override
    public ConductorModel getOne(Long id) throws ExceptionObjectNotFound {
        return conductorRepository.findById(id).orElseThrow(()->new ExceptionObjectNotFound("Conductor no encontrado"));
    }

    @Override
    public ConductorModel save(ConductorModel conductor) {
        if(!conductorRepository.existsByCedula(conductor.getCedula())){
            UserModel user = conductor.getUser();
            userService.save(user);
            return conductorRepository.save(conductor);
        }
        return null;
    }

    @Override
    public ConductorModel update(Long id,ConductorModel conductorNuevo) throws ExceptionObjectNotFound {
        ConductorModel conductor = conductorRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Conductor no encontrado"));

            conductor.setApellido(conductorNuevo.getApellido());
            conductor.setCedula(conductorNuevo.getCedula());
            conductor.setDireccion(conductorNuevo.getDireccion());
            conductor.setNombre(conductorNuevo.getNombre());
            conductor.setTelefono(conductorNuevo.getTelefono());
            return conductorRepository.save(conductor);

    }

    @Override
    public String delete(Long id) throws ExceptionObjectNotFound {
        ConductorModel conductor = conductorRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Conductor no encontrado"));

        conductorRepository.delete(conductor);
        return "Conductor con ID " + id + " eliminado satisfactoriamente";

    }
}
