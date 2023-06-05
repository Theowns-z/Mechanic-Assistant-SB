package com.Theowns.controllers;

import com.Theowns.DTO.ResponseObject;
import com.Theowns.models.VehiculoModel;
import com.Theowns.services.VehiculoService;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculo")
@CrossOrigin(origins = "*")
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
            return ResponseEntity.ok(new ResponseObject<VehiculoModel>("Vehiculo con ID: " + id + " Encontrado ", vehiculoService.getOne(id)));
        } catch (ExceptionObjectNotFound e) {
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado ", e.getMessage()));
        }
    }

    @GetMapping("/conductor/{conductorId}")
    public ResponseEntity<ResponseObject<?>> save(@PathVariable("conductorId") Long conductorId) throws ExceptionObjectNotFound {
        return ResponseEntity.ok(new ResponseObject<List<VehiculoModel>>("Vehiculos del conductor con id " + conductorId, vehiculoService.getbyConductor(conductorId)));
    }

    @PostMapping("/conductor/{conductorId}")
    public ResponseEntity<ResponseObject<?>> save(@RequestBody VehiculoModel vehiculo, @PathVariable("conductorId") Long conductorId) throws ExceptionObjectNotFound {
        try {
            return ResponseEntity.ok(new ResponseObject<VehiculoModel>("Vehiculo del conductor guardado correctamente ", vehiculoService.save(vehiculo,conductorId)));
        } catch (ExceptionObjectNotFound e) {
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado ", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject<?>> update(@RequestBody VehiculoModel vehiculo, @PathVariable("id") Long id) throws ExceptionObjectNotFound {
        try {
            return ResponseEntity.ok(new ResponseObject<VehiculoModel>("Vehiculo con ID: " + id + " Encontrado", vehiculoService.update(id, vehiculo)));
        } catch (ExceptionObjectNotFound e) {
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado ", e.getMessage()));
        }
    }


    @DeleteMapping("/{id}")
    public ResponseObject<?> delete(@PathVariable("id") Long id) throws ExceptionObjectNotFound{
        try{
            return new ResponseObject<String>("Vehiculo ha sido eliminado correctamente",vehiculoService.delete(id));
        }catch (ExceptionObjectNotFound e){
            return new ResponseObject<String>("Error! Vehiculo no eliminado",e.getMessage());
        }
    }


}

    
    
    
    

