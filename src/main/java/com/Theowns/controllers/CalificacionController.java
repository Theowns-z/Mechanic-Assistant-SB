package com.Theowns.controllers;

import com.Theowns.DTO.CalificacionDTO;
import com.Theowns.DTO.ResponseObject;
import com.Theowns.models.CalificacionModel;
import com.Theowns.repositories.CalificacionRepository;
import com.Theowns.services.CalificacionService;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calificacion")
public class CalificacionController {
    @Autowired
    CalificacionService calificacionService;

    @GetMapping("/mecanico/{mecanicoid}")
    public ResponseEntity<ResponseObject<?>> getCalificacion(@PathVariable("mecanicoid") Long id){
        return ResponseEntity.ok(new ResponseObject<CalificacionDTO>("Calificacion de mecanico con id " + id ,calificacionService.getCalificacion(id)));
    }

    @PostMapping("/mecanico/{mecanicoid}")
    public ResponseEntity<ResponseObject<?>> saveCalificacion(@PathVariable("mecanicoid") Long id,@RequestBody CalificacionModel calificacion) throws ExceptionObjectNotFound {
        try{
            return ResponseEntity.ok(new ResponseObject<String>("Calificacion de mecanico con id " + id ,calificacionService.saveCalificacion(id,calificacion)));
        }catch (ExceptionObjectNotFound e){
            return ResponseEntity.status(404).body(new ResponseObject<String>("Error! No encontrado",e.getMessage()));
        }
    }
}
