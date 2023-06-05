package com.Theowns.controllers;

import com.Theowns.DTO.ResponseObject;
import com.Theowns.models.GruaModel;
import com.Theowns.services.GruaService;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grua")
@CrossOrigin(origins = "*")
public class GruaController {


    @Autowired
    GruaService gruaService;


    @GetMapping
    public List<GruaModel> getAll() {
        return (gruaService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject<?>> getOne(@PathVariable("id") Long id) throws ExceptionObjectNotFound {
        try {
            return ResponseEntity.ok(new ResponseObject<GruaModel>("Grua con ID: " + id + "Encontrada ", gruaService.getOne(id)));
        } catch (ExceptionObjectNotFound e) {
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado ", e.getMessage()));
        }
    }

    @PostMapping()
    public ResponseEntity<ResponseObject<?>> save(@RequestBody GruaModel grua) throws ExceptionObjectNotFound {
        try {
            return ResponseEntity.ok(new ResponseObject<GruaModel>("Grua fue guarardada correctamente ", gruaService.save(grua)));
        } catch (ExceptionObjectNotFound e) {
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado ", e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject<?>> update(@RequestBody GruaModel grua, @PathVariable("id") Long id) throws ExceptionObjectNotFound {
        try {
            return ResponseEntity.ok(new ResponseObject<GruaModel>("Grua con ID: " + id + " Encontrada", gruaService.update(id, grua)));
        } catch (ExceptionObjectNotFound e) {
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado ", e.getMessage()));
        }
    }


    @DeleteMapping("/{id}")
    public ResponseObject<?> delete(@PathVariable("id") Long id) throws ExceptionObjectNotFound{
        try{
            ResponseEntity.ok(gruaService.delete(id));
            return new ResponseObject<String>("Grua ha sido eliminada correctamente","Grua con id " + id + " eliminada");
        }catch (ExceptionObjectNotFound e){
            return new ResponseObject<String>("Error! Grua no eliminada",e.getMessage());
        }
    }

}
