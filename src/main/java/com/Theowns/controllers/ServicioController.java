package com.Theowns.controllers;

import com.Theowns.DTO.PersonaDTO;
import com.Theowns.DTO.ResponseObject;
import com.Theowns.DTO.ServicioDTO;
import com.Theowns.models.ConductorModel;
import com.Theowns.models.ServicioModel;
import com.Theowns.services.ServicioService;
import com.Theowns.services.exceptions.DuplicateException;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicio")
@CrossOrigin(origins = "*")
public class ServicioController {
    @Autowired
    ServicioService servicioService;

    @GetMapping()
    public ResponseEntity<ResponseObject<?>> getServicios(){
        return ResponseEntity.ok(new ResponseObject<List<ServicioDTO>>("Servicios encontrados", servicioService.getAll()));
    }

    @GetMapping("/conductor/{conductorId}")
    public ResponseEntity<ResponseObject<?>> getServiciosByConductor(@PathVariable("conductorId") Long conductorId){
            return ResponseEntity.ok(new ResponseObject<List<ServicioDTO>>("Servicios del conductor con id " + conductorId + " encontrados", servicioService.getByConductor(conductorId)));
    }

    @GetMapping("/mecanico/{mecanicoId}")
    public ResponseEntity<ResponseObject<?>> getServiciosByMecanico(@PathVariable("mecanicoId") Long mecanicoId){
        return ResponseEntity.ok(new ResponseObject<List<ServicioDTO>>("Servicios del mecanico con id " + mecanicoId + " encontrados", servicioService.getByMecanico(mecanicoId)));
    }

    @PostMapping()
    public ResponseEntity<ResponseObject<?>> save(@RequestBody ServicioModel servicio) throws DuplicateException {
        return ResponseEntity.ok( new ResponseObject<ServicioDTO>( "Servicio guardado correctamente",servicioService.save(servicio)));
    }
}
