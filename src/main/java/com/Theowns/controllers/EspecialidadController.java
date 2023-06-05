package com.Theowns.controllers;

import com.Theowns.DTO.EspecialidadDTO;
import com.Theowns.DTO.ResponseObject;
import com.Theowns.models.EspecialidadModel;
import com.Theowns.services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/especialidad")
@CrossOrigin(origins = "*")
public class EspecialidadController {
    @Autowired
    EspecialidadService especialidadService;

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject<EspecialidadDTO>> getAll(@PathVariable("id") Long id){
        return ResponseEntity.ok(new ResponseObject<EspecialidadDTO>("Especialidades de conductor con id " + id + " encontradas",especialidadService.findEspecialidadesByMecanicoId(id)));
    }

    @PostMapping("/mecanico/{id}")
    public ResponseEntity<ResponseObject<String>> toggleEspecialidad( @PathVariable("id") Long id,@RequestBody EspecialidadModel especialidad){
        return ResponseEntity.ok(new ResponseObject<String>("Especialidad de conductor con id " + id + " actualizado",especialidadService.toggleEspecialidad(id,especialidad)));
    }



}
