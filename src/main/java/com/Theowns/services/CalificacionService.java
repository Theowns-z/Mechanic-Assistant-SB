package com.Theowns.services;

import com.Theowns.DTO.CalificacionDTO;
import com.Theowns.DTO.MecanicoDTO;
import com.Theowns.DTO.PersonaDTO;
import com.Theowns.models.CalificacionModel;
import com.Theowns.models.ConductorModel;
import com.Theowns.models.MecanicoModel;
import com.Theowns.repositories.CalificacionRepository;
import com.Theowns.services.exceptions.DuplicateException;
import com.Theowns.services.exceptions.ExceptionObjectNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionService{
    @Autowired
    CalificacionRepository calificacionRepository;
    @Autowired
    MecanicoService mecanicoService;


    public CalificacionDTO getCalificacion(Long id) throws ExceptionObjectNotFound {
        List<CalificacionModel> calificaciones = calificacionRepository.findAllByMecanico_Id(id);
        double media = Utils.calcularCalificacion(calificaciones);

        return new CalificacionDTO(calificaciones.size(),media);
    }

    public String saveCalificacion(Long id,CalificacionModel calificacion) throws ExceptionObjectNotFound{
        MecanicoModel mecanico = mecanicoService.getOneMecanico(id);
        calificacion.setMecanico(mecanico);
        calificacionRepository.save(calificacion);
        return "Se ha guardado la calificacion ("+ calificacion.getCalificacion()+") del mecanico "+ mecanico.getNombre()+" correctamente";
    }
}
