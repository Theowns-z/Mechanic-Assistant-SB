package com.Theowns.services;

import com.Theowns.DTO.MecanicoDTO;
import com.Theowns.models.CalificacionModel;
import com.Theowns.models.EspecialidadModel;
import com.Theowns.models.MecanicoModel;
import com.Theowns.models.enums.Especialidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Utils {


    public static double calcularCalificacion(List<CalificacionModel> calificaciones) {
        double media = 0;
        for (CalificacionModel calificacion : calificaciones) {
            media += calificacion.getCalificacion();
        }
        media = media / calificaciones.size();
        return media;
    }

    public static List<Especialidades> aplanarEspecialidades(List<EspecialidadModel> especialidades){
        List<Especialidades> especialidadesList = new ArrayList<>();
        for (EspecialidadModel especialidad: especialidades){
            especialidadesList.add(especialidad.getTipo());
        }
        return especialidadesList;
    }

    public static MecanicoDTO crearMecanicoDTO(MecanicoModel persona) {
        List<EspecialidadModel> especialidades = persona.getEspecialidades();
        List<Especialidades> especialidadesList = aplanarEspecialidades(especialidades);
        double media = calcularCalificacion(persona.getCalificacion());
        return new MecanicoDTO(persona.getId(), persona.getCedula(), persona.getNombre(),
                persona.getApellido(), persona.getDireccion(), persona.getTelefono(),especialidadesList,media);
    }
}