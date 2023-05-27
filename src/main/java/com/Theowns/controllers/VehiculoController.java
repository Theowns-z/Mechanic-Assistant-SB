package com.Theowns.controllers;

import com.Theowns.models.VehiculoModel;
import com.Theowns.models.VehiculoModel;
import com.Theowns.services.VehiculoService;
import com.Theowns.services.VehiculoService;
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
    public List<VehiculoModel> getAll(){
        return (vehiculoService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<VehiculoModel> getOne(@PathVariable("id") Long id){
        return ResponseEntity.ok(vehiculoService.getOne(id));
    }


    @PostMapping()
    public ResponseEntity<VehiculoModel> save(@RequestBody VehiculoModel vehiculo){
        return ResponseEntity.ok( vehiculoService.save(vehiculo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehiculoModel> update(@RequestBody VehiculoModel vehiculo, @PathVariable("id") Long id){
        return ResponseEntity.ok(vehiculoService.update(id,vehiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(vehiculoService.delete(id));
    }
}

    
    
    
    

