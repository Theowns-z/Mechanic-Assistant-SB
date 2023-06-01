package com.Theowns.controllers;

import com.Theowns.models.EspecialidadModel;
import com.Theowns.services.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/especialidad")
public class EspecialidadController {
    @Autowired
    EspecialidadService especialidadService;

    @GetMapping("/{id}")
    public List<EspecialidadModel> getAll(@PathVariable("id") Long id){
        return (especialidadService.findEspecialidadesByConductorId(id));
    }

}
