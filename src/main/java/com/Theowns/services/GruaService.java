package com.Theowns.services;

import com.Theowns.models.GruaModel;
import com.Theowns.repositories.GruaRepository;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GruaService  {
    @Autowired
    GruaRepository gruaRepository;

    public List<GruaModel> getAll() {
        return (List<GruaModel>) gruaRepository.findAll();
    }

    public GruaModel getOne(Long id) throws ExceptionObjectNotFound {
        return gruaRepository.findById(id).orElseThrow(()->new ExceptionObjectNotFound("Grua no encontrado"));
    }

    public GruaModel save(GruaModel grua) {
        return gruaRepository.save(grua);
    }

    public GruaModel update(Long id,GruaModel gruaNuevo) throws ExceptionObjectNotFound {
        GruaModel grua = gruaRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Grua no encontrado"));

        grua.setCoordenada_x(gruaNuevo.getCoordenada_x());
        grua.setCoordenada_y(gruaNuevo.getCoordenada_y());
        grua.setDireccion(gruaNuevo.getDireccion());
        grua.setNombre(gruaNuevo.getNombre());
        grua.setTelefono(gruaNuevo.getTelefono());
        grua.setTipo(gruaNuevo.getTipo());

        return gruaRepository.save(grua);

    }

    public String delete(Long id) throws ExceptionObjectNotFound {
        GruaModel grua = gruaRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Grua no encontrado"));

        gruaRepository.delete(grua);
        return "Grua con ID " + id + " eliminado satisfactoriamente";

    }
}
