package com.Theowns.controllers;

import com.Theowns.DTO.ResponseObject;
import com.Theowns.models.TallerModel;
import com.Theowns.services.TallerService;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taller")
@CrossOrigin(origins = "*")
public class TallerController {

    @Autowired
    TallerService tallerService;


    @GetMapping
    public List<TallerModel> getAll() {
        return (tallerService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject<?>> getOne(@PathVariable("id") Long id) throws ExceptionObjectNotFound {
        try {
            return ResponseEntity.ok(new ResponseObject<TallerModel>("Taller con ID: " + id + "Encontrada", tallerService.getOne(id)));
        } catch (ExceptionObjectNotFound e) {
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado ", e.getMessage()));
        }
    }

    @PostMapping()
    public ResponseEntity<ResponseObject<?>> save(@RequestBody TallerModel taller) throws ExceptionObjectNotFound {
        try {
            return ResponseEntity.ok(new ResponseObject<TallerModel>("Taller fue guardada correctamente ", tallerService.save(taller)));
        } catch (ExceptionObjectNotFound e) {
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado ", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject<?>> update(@RequestBody TallerModel taller, @PathVariable("id") Long id) throws ExceptionObjectNotFound {
        try {
            return ResponseEntity.ok(new ResponseObject<TallerModel>("Taller con ID: " + id + " Encontrada", tallerService.update(id, taller)));
        } catch (ExceptionObjectNotFound e) {
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado ", e.getMessage()));
        }
    }


    @DeleteMapping("/{id}")
    public ResponseObject<?> delete(@PathVariable("id") Long id) throws ExceptionObjectNotFound{
        try{
            ResponseEntity.ok(tallerService.delete(id));
            return new ResponseObject<String>("Taller ha sido eliminada correctamente","Taller con id " + id + " eliminada");
        }catch (ExceptionObjectNotFound e){
            return new ResponseObject<String>("Error! Taller no eliminada",e.getMessage());
        }
    }


}
