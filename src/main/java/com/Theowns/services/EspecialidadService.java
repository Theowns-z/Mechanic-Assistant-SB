package com.Theowns.services;

import com.Theowns.DTO.EspecialidadDTO;
import com.Theowns.DTO.MecanicoDTO;
import com.Theowns.models.EspecialidadModel;
import com.Theowns.models.MecanicoModel;
import com.Theowns.models.enums.Especialidades;
import com.Theowns.repositories.EspecialidadRepository;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EspecialidadService {
    @Autowired
    EspecialidadRepository especialidadRepository;
    @Autowired
    MecanicoService mecanicoService;

    public EspecialidadDTO findEspecialidadesByMecanicoId(Long id){
        List<EspecialidadModel> especialidades =  especialidadRepository.findAllByMecanico_Id(id);

        List<Especialidades> especialidadesList = Utils.aplanarEspecialidades(especialidades);
        return new EspecialidadDTO(especialidades.size(),especialidadesList);

    }

    public String toggleEspecialidad(Long id,EspecialidadModel especialidad) throws ExceptionObjectNotFound {

        MecanicoModel mecanico = mecanicoService.getOneMecanico(id);
        if(especialidadRepository.existsByMecanico_IdAndTipo(mecanico.getId(),especialidad.getTipo())){
            especialidadRepository.removeByMecanico_IdAndTipo(mecanico.getId(),especialidad.getTipo());;
            return "Especialidad del mecanico "+mecanico.getNombre()+" eliminada correctamente";
        };
        especialidad.setMecanico(mecanico);
        especialidadRepository.save(especialidad);
        return "Especialidad del mecanico "+mecanico.getNombre() +" agregada correctamente";

    }


}
