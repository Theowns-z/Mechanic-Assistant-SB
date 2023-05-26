package com.Theowns.services;

import com.Theowns.models.TallerModel;
import com.Theowns.repositories.TallerRepository;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import com.Theowns.services.interfaces.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TallerService implements InterfaceService<TallerModel> {
    @Autowired
    TallerRepository tallerRepository;

    @Override
    public List<TallerModel> getAll() {
        return (List<TallerModel>) tallerRepository.findAll();
    }

    @Override
    public TallerModel getOne(Long id) throws ExceptionObjectNotFound {
        return tallerRepository.findById(id).orElseThrow(()->new ExceptionObjectNotFound("Taller no encontrado"));
    }

    @Override
    public TallerModel save(TallerModel taller) {
        return tallerRepository.save(taller);
    }

    @Override
    public TallerModel update(Long id,TallerModel tallerNuevo) throws ExceptionObjectNotFound {
        TallerModel taller = tallerRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Taller no encontrado"));

        taller.setCoordenada_x(tallerNuevo.getCoordenada_x());
        taller.setCoordenada_y(tallerNuevo.getCoordenada_y());
        taller.setDireccion(tallerNuevo.getDireccion());
        taller.setNombre(tallerNuevo.getNombre());
        taller.setTelefono(tallerNuevo.getTelefono());

        return tallerRepository.save(taller);

    }

    @Override
    public String delete(Long id) throws ExceptionObjectNotFound {
        TallerModel taller = tallerRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Taller no encontrado"));

        tallerRepository.delete(taller);
        return "Taller con ID " + id + " eliminado satisfactoriamente";

    }
}
