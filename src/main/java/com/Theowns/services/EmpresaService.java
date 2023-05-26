package com.Theowns.services;

import com.Theowns.models.EmpresaModel;
import com.Theowns.repositories.EmpresaRepository;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import com.Theowns.services.interfaces.InterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService implements InterfaceService<EmpresaModel> {
    @Autowired
    EmpresaRepository empresaRepository;

    @Override
    public List<EmpresaModel> getAll() {
        return (List<EmpresaModel>) empresaRepository.findAll();
    }

    @Override
    public EmpresaModel getOne(Long id) throws ExceptionObjectNotFound {
        return empresaRepository.findById(id).orElseThrow(()->new ExceptionObjectNotFound("Empresa no encontrado"));
    }

    @Override
    public EmpresaModel save(EmpresaModel empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public EmpresaModel update(Long id,EmpresaModel empresaNuevo) throws ExceptionObjectNotFound {
        EmpresaModel empresa = empresaRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Empresa no encontrado"));

        empresa.setCoordenada_x(empresaNuevo.getCoordenada_x());
        empresa.setCoordenada_y(empresaNuevo.getCoordenada_y());
        empresa.setDireccion(empresaNuevo.getDireccion());
        empresa.setNombre(empresaNuevo.getNombre());
        empresa.setTelefono(empresaNuevo.getTelefono());
        return empresaRepository.save(empresa);

    }

    @Override
    public String delete(Long id) throws ExceptionObjectNotFound {
        EmpresaModel empresa = empresaRepository
                .findById(id)
                .orElseThrow(()->new ExceptionObjectNotFound("Empresa no encontrado"));

        empresaRepository.delete(empresa);
        return "Empresa con ID " + id + " eliminado satisfactoriamente";

    }
}
