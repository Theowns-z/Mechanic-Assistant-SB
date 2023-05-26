package com.Theowns.controllers;

import com.Theowns.DAO.ConductorDAO;
import com.Theowns.models.ConductorModel;
import com.Theowns.services.ConductorService;
import com.Theowns.services.exceptions.DuplicateException;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conductor")
public class ConductorController {
    @Autowired
    ConductorService conductorService;


    @GetMapping
    public List<ConductorDAO> getAll(){
        return (conductorService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseObject<?> getOne(@PathVariable("id") Long id) throws ExceptionObjectNotFound{
        try{
            return new ResponseObject<ConductorDAO>("Conductor con id " + id + " encontrado", conductorService.getOne(id));
        }catch (ExceptionObjectNotFound e){
            return new ResponseObject<String>("Error! No encontrado", e.getMessage());
        }

    }


    @PostMapping()
    public ResponseObject<?> save(@RequestBody ConductorModel conductor) throws DuplicateException {
        try {
        return new ResponseObject<ConductorModel>( "Conductor guardado correctamente",conductorService.save(conductor));
        }catch (DuplicateException e){
            return new ResponseObject<String>("Error! No guardado",e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseObject<?> update(@RequestBody ConductorModel conductor, @PathVariable("id") Long id) throws ExceptionObjectNotFound {
        try{
            ConductorDAO   conductorDAO = conductorService.update(id,conductor);
            return new ResponseObject<ConductorDAO>("Conductor actualizado correctamente", conductorDAO);
        }catch (ExceptionObjectNotFound e){
            return new ResponseObject<String>( "Error! No actualizado", e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseObject<?> delete(@PathVariable("id") Long id) throws ExceptionObjectNotFound{
        try{
            ResponseEntity.ok(conductorService.delete(id));
            return new ResponseObject<String>("Conductor eliminado correctamente","Conductor con id " + id + " eliminado");
        }catch (ExceptionObjectNotFound e){
            return new ResponseObject<String>("Error! No eliminado",e.getMessage());
        }
    }
}
