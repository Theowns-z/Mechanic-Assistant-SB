package com.Theowns.services;

import com.Theowns.models.VehiculoModel;
import com.Theowns.repositories.VehiculoRepository;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import com.Theowns.services.interfaces.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService implements InterfaceService<VehiculoModel> {
    @Autowired
    VehiculoRepository vehiculoRepository;

    @Override
    public List<VehiculoModel> getAll() {
        return (List<VehiculoModel>) vehiculoRepository.findAll();
    }

    @Override
    public VehiculoModel getOne(Long id) throws ExceptionObjectNotFound {
        return vehiculoRepository.findById(id).orElseThrow(()->new ExceptionObjectNotFound("Vehiculo no encontrado"));
    }

    @Override
    public VehiculoModel save(VehiculoModel vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }

    @Override
    public VehiculoModel update(Long id,VehiculoModel vehiculoNuevo) throws ExceptionObjectNotFound {
        VehiculoModel vehiculo = vehiculoRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Vehiculo no encontrado"));

        vehiculo.setPlaca(vehiculoNuevo.getPlaca());
        vehiculo.setModelo(vehiculoNuevo.getModelo());
        vehiculo.setFalla(vehiculoNuevo.getFalla()  );
        return vehiculoRepository.save(vehiculo);

    }

    @Override
    public String delete(Long id) throws ExceptionObjectNotFound {
        VehiculoModel vehiculo = vehiculoRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Vehiculo no encontrado"));

        vehiculoRepository.delete(vehiculo);
        return "Vehiculo con ID " + id + " eliminado satisfactoriamente";

    }
}
