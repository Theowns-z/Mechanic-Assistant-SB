package com.Theowns.controllers;

import com.Theowns.models.GruaModel;
import com.Theowns.services.GruaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grua")
public class GruaController {


    @Autowired
    GruaService gruaService;


    @GetMapping
    public List<GruaModel> getAll(){
        return (gruaService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<GruaModel> getOne(@PathVariable("id") Long id){
        return ResponseEntity.ok(gruaService.getOne(id));
    }


    @PostMapping()
    public ResponseEntity<ResponseObject<?>> save(@RequestBody GruaModel grua){
        try{

            return ResponseEntity.ok( new ResponseObject<GruaModel>("Grua actualizada correctamente", GruaService.update()));
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<GruaModel> update(@RequestBody GruaModel grua, @PathVariable("id") Long id){
        return ResponseEntity.ok(gruaService.update(id,grua));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(gruaService.delete(id));
    }
}
