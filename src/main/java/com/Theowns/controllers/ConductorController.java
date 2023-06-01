package com.Theowns.controllers;

import com.Theowns.DAO.PersonaDTO;
import com.Theowns.DAO.ResponseObject;
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
    public List<PersonaDTO> getAll(){
        return (conductorService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject<?>> getOne(@PathVariable("id") Long id) throws ExceptionObjectNotFound{
        try{
            return ResponseEntity.ok( new ResponseObject<PersonaDTO>("Conductor con id " + id + " encontrado", conductorService.getOne(id)));
        }catch (ExceptionObjectNotFound e){
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado", e.getMessage()));
        }

    }


    @PostMapping()
    public ResponseEntity<ResponseObject<?>> save(@RequestBody ConductorModel conductor) throws DuplicateException {
        try {
        return ResponseEntity.ok( new ResponseObject<ConductorModel>( "Conductor guardado correctamente",conductorService.save(conductor)));
        }catch (DuplicateException e){
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No guardado",e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject<?>> update(@RequestBody ConductorModel conductor, @PathVariable("id") Long id) throws ExceptionObjectNotFound {
        try{

            PersonaDTO   conductorDAO = conductorService.update(id,conductor);
            return ResponseEntity.ok(new ResponseObject<PersonaDTO>("Conductor actualizado correctamente", conductorDAO));
        }catch (ExceptionObjectNotFound e){
            return ResponseEntity.status(404).body(new ResponseObject<String>( "Error! No actualizado", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject<?>> delete(@PathVariable("id") Long id) throws ExceptionObjectNotFound{
        try{
            return ResponseEntity.ok(new ResponseObject<String>("Conductor eliminado correctamente","Conductor con id " + id + " eliminado"));
        }catch (ExceptionObjectNotFound e){
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No eliminado",e.getMessage()));
        }
    }
}
