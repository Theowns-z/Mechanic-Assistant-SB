package com.Theowns.controllers;

import com.Theowns.models.ConductorModel;
import com.Theowns.services.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/conductor")
public class ConductorController {
    @Autowired
    ConductorService conductorService;
    @GetMapping
    public List<ConductorModel> getAll(){
        return (conductorService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ConductorModel> getOne(@PathVariable("id") Long id){
        return ResponseEntity.ok(conductorService.getOne(id));
    }


    @PostMapping()
    public ResponseEntity<ConductorModel> save(@RequestBody ConductorModel conductor){
        return ResponseEntity.ok(conductorService.save(conductor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConductorModel> save(@RequestBody ConductorModel conductor, @PathVariable("id") Long id){
        return ResponseEntity.ok(conductorService.update(id,conductor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(conductorService.delete(id));
    }
}
