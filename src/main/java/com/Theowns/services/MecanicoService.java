package com.Theowns.services;

import com.Theowns.DAO.MecanicoDAO;
import com.Theowns.models.MecanicoModel;
import com.Theowns.repositories.MecanicoRepository;
import com.Theowns.services.exceptions.DuplicateException;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MecanicoService {

    @Autowired
    MecanicoRepository mecanicoRepository;
    @Autowired
    UserService userService;

    public List<MecanicoDAO> getAll() {

        List<MecanicoModel> mecanicos = mecanicoRepository.findAll();
        List<MecanicoDAO> mecanicoResponse = new ArrayList<>();
        for (MecanicoModel mecanico : mecanicos) {
            MecanicoDAO mecanicoDAO = new MecanicoDAO(mecanico.getId(),mecanico.getNombre(),mecanico.getApellido(),mecanico.getDireccion(), mecanico.getTelefono());
            mecanicoResponse.add(mecanicoDAO);
        }
        return mecanicoResponse;
    }

    public MecanicoDAO getOne(Long id) throws ExceptionObjectNotFound {
        MecanicoModel mecanico = mecanicoRepository.findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Mecanico con id "+ id+ " no encontrado"));
        return new MecanicoDAO(mecanico.getId(),mecanico.getNombre(),mecanico.getApellido(),mecanico.getDireccion(), mecanico.getTelefono());
    }

    public MecanicoDAO update(Long id, MecanicoModel mecanicoNuevo) throws ExceptionObjectNotFound {
        MecanicoModel mecanico = mecanicoRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Mecanico con id "+ id +" no encontrado"));

        mecanico.setApellido(mecanicoNuevo.getApellido());
        mecanico.setDireccion(mecanicoNuevo.getDireccion());
        mecanico.setNombre(mecanicoNuevo.getNombre());
        mecanico.setTelefono(mecanicoNuevo.getTelefono());

        mecanicoRepository.save(mecanico);
        return  new MecanicoDAO(mecanico.getId(),mecanico.getNombre(),mecanico.getApellido(),mecanico.getDireccion(), mecanico.getTelefono());

    }


    public MecanicoModel save(MecanicoModel mecanico) throws DuplicateException {
        if (mecanicoRepository.existsByCedula(mecanico.getCedula())) {
            throw new DuplicateException("La cedula "+ mecanico.getCedula()+" ya está registrada");
        }
        userService.save(mecanico.getUser());
        return mecanicoRepository.save(mecanico);
    }

    public String delete(Long id) throws ExceptionObjectNotFound {
        MecanicoModel mecanico = mecanicoRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Mecanico con id "+ id +" no encontrado"));

        mecanicoRepository.delete(mecanico);
        return "Mecanico con ID " + id + " eliminado satisfactoriamente";

    }
}

    

