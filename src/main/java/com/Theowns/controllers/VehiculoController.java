package com.Theowns.controllers;

import com.Theowns.models.VehiculoModel;
import com.Theowns.models.VehiculoModel;
import com.Theowns.models.VehiculoModel;
import com.Theowns.services.VehiculoService;
import com.Theowns.services.VehiculoService;
import com.Theowns.services.VehiculoService;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculo")
public class VehiculoController {

    @Autowired
    VehiculoService vehiculoService;


    @GetMapping
    public List<VehiculoModel> getAll() {
        return (vehiculoService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject<?>> getOne(@PathVariable("id") Long id) throws ExceptionObjectNotFound {
        try {
            return ResponseEntity.ok(new ResponseObject<VehiculoModel>("Vehiculo con ID: " + id + "Encontrada", vehiculoService.getOne(id)));
        } catch (ExceptionObjectNotFound e) {
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado ", e.getMessage()));
        }
    }

    @PostMapping()
    public ResponseEntity<ResponseObject<?>> save(@RequestBody VehiculoModel vehiculo) throws ExceptionObjectNotFound {
        try {
            return ResponseEntity.ok(new ResponseObject<VehiculoModel>("Vehiculo fue guarardada correctamente ", vehiculoService.save(vehiculo)));
        } catch (ExceptionObjectNotFound e) {
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado ", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject<?>> update(@RequestBody VehiculoModel vehiculo, @PathVariable("id") Long id) throws ExceptionObjectNotFound {
        try {
            return ResponseEntity.ok(new ResponseObject<VehiculoModel>("Vehiculo con ID: " + id + " Encontrada", vehiculoService.update(id, vehiculo)));
        } catch (ExceptionObjectNotFound e) {
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado ", e.getMessage()));
        }
    }


    @DeleteMapping("/{id}")
    public ResponseObject<?> delete(@PathVariable("id") Long id) throws ExceptionObjectNotFound{
        try{
            ResponseEntity.ok(vehiculoService.delete(id));
            return new ResponseObject<String>("Vehiculo ha sido eliminada correctamente","Vehiculo con id " + id + " eliminada");
        }catch (ExceptionObjectNotFound e){
            return new ResponseObject<String>("Error! Vehiculo no eliminada",e.getMessage());
        }
    }


}

    
    
    
    

