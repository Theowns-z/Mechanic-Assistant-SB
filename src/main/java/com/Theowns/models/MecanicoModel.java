package com.Theowns.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mecanicos")
public class MecanicoModel extends PersonaModel {

    @OneToMany(mappedBy="mecanico")
    private List<EspecialidadModel> especialidades;

    @OneToMany(mappedBy="mecanico")
    private List<ServicioModel> servicio;

    @OneToMany(mappedBy="mecanico")
    private List<CalificacionModel> calificacion;

}


