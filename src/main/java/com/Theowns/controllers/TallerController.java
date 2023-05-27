package com.Theowns.controllers;

import com.Theowns.models.TallerModel;
import com.Theowns.services.TallerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taller")
public class TallerController {

    @Autowired
    TallerService tallerService;


    @GetMapping
    public List<TallerModel> getAll(){
        return (tallerService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<TallerModel> getOne(@PathVariable("id") Long id){
        return ResponseEntity.ok(tallerService.getOne(id));
    }


    @PostMapping()
    public ResponseEntity<TallerModel> save(@RequestBody TallerModel taller){
        return ResponseEntity.ok( tallerService.save(taller));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TallerModel> update(@RequestBody TallerModel taller, @PathVariable("id") Long id){
        return ResponseEntity.ok(tallerService.update(id,taller));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(tallerService.delete(id));
    }

}
