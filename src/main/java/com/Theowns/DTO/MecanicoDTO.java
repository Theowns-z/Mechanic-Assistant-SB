package com.Theowns.DTO;

import com.Theowns.models.EspecialidadModel;
import com.Theowns.models.MecanicoModel;
import com.Theowns.models.enums.Especialidades;
import com.Theowns.services.CalificacionService;
import com.Theowns.services.Utils;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class MecanicoDTO {
    private long id;
    private long cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private List<Especialidades> especialidades;
    private double calificacion;

}
