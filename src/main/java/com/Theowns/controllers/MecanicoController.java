package com.Theowns.controllers;


import com.Theowns.DTO.MecanicoDTO;
import com.Theowns.DTO.PersonaDTO;
import com.Theowns.DTO.ResponseObject;
import com.Theowns.models.MecanicoModel;
import com.Theowns.services.MecanicoService;
import com.Theowns.services.exceptions.DuplicateException;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/mecanico")
public class MecanicoController {

    @Autowired
    MecanicoService mecanicoService;


    @GetMapping
    public List<MecanicoDTO> getAll(){
        return (mecanicoService.getAll());
    }


    @GetMapping("/{id}")
    public ResponseObject<?> getOne(@PathVariable("id") Long id) throws ExceptionObjectNotFound {
        try{
            return new ResponseObject<MecanicoDTO>("Mecanico con id " + id + " encontrado", mecanicoService.getOne(id));
        }catch (ExceptionObjectNotFound e){
            return new ResponseObject<String>("Error! No encontrado", e.getMessage());
        }

    }


    @PostMapping()
    public ResponseObject<?> save(@RequestBody MecanicoModel mecanico) throws DuplicateException {
        try {
            return new ResponseObject<MecanicoModel>( "Mecanico guardado correctamente",mecanicoService.save(mecanico));
        }catch (DuplicateException e){
            return new ResponseObject<String>("Error! No guardado",e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseObject<?> update(@RequestBody MecanicoModel mecanico, @PathVariable("id") Long id) throws ExceptionObjectNotFound {
        try{
            PersonaDTO  mecanicoDAO = mecanicoService.update(id,mecanico);
            return new ResponseObject<PersonaDTO>("Mecanico actualizado correctamente", mecanicoDAO);
        }catch (ExceptionObjectNotFound e){
            return new ResponseObject<String>( "Error! No actualizado", e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseObject<?> delete(@PathVariable("id") Long id) throws ExceptionObjectNotFound{
        try{
            ResponseEntity.ok(mecanicoService.delete(id));
            return new ResponseObject<String>("Mecanico eliminado correctamente","Mecanico con id " + id + " eliminado");
        }catch (ExceptionObjectNotFound e){
            return new ResponseObject<String>("Error! No eliminado",e.getMessage());
        }
    }
}
