package com.Theowns.services;

import com.Theowns.models.ConductorModel;
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
    @Autowired
    ConductorService conductorService;

    public List<VehiculoModel> getAll() {
        return (List<VehiculoModel>) vehiculoRepository.findAll();
    }

    public VehiculoModel getOne(Long id) throws ExceptionObjectNotFound {
        return vehiculoRepository.findById(id).orElseThrow(()->new ExceptionObjectNotFound("Vehiculo no encontrado"));
    }

    public List<VehiculoModel> getbyConductor(Long conductorId) {
        return vehiculoRepository.findAllByConductor_Id(conductorId);
    }


    public VehiculoModel save(VehiculoModel vehiculo, Long conductorId) {

        ConductorModel conductor = conductorService.getOneConductor(conductorId);
        vehiculo.setConductor(conductor);
        return vehiculoRepository.save(vehiculo);
    }

    public VehiculoModel update(Long id,VehiculoModel vehiculoNuevo) throws ExceptionObjectNotFound {
        VehiculoModel vehiculo = vehiculoRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Vehiculo no encontrado"));

        vehiculo.setPlaca(vehiculoNuevo.getPlaca());
        vehiculo.setModelo(vehiculoNuevo.getModelo());
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
