package com.Theowns.services;

import com.Theowns.models.VehiculoModel;
import com.Theowns.repositories.VehiculoRepository;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    @Autowired
    VehiculoRepository vehiculoRepository;

    public List<VehiculoModel> getAll() {
        return (List<VehiculoModel>) vehiculoRepository.findAll();
    }

    public VehiculoModel getOne(Long id) throws ExceptionObjectNotFound {
        return vehiculoRepository.findById(id).orElseThrow(()->new ExceptionObjectNotFound("Vehiculo no encontrado"));
    }

    public VehiculoModel save(VehiculoModel vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    public VehiculoModel update(Long id,VehiculoModel vehiculoNuevo) throws ExceptionObjectNotFound {
        VehiculoModel vehiculo = vehiculoRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Vehiculo no encontrado"));

        vehiculo.setPlaca(vehiculoNuevo.getPlaca());
        vehiculo.setModelo(vehiculoNuevo.getModelo());
        vehiculo.setFalla(vehiculoNuevo.getFalla()  );
        return vehiculoRepository.save(vehiculo);

    }

    public String delete(Long id) throws ExceptionObjectNotFound {
        VehiculoModel vehiculo = vehiculoRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Vehiculo no encontrado"));

        vehiculoRepository.delete(vehiculo);
        return "Vehiculo con ID " + id + " eliminado satisfactoriamente";

    }
}
