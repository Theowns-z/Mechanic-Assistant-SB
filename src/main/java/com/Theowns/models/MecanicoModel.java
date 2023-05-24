package com.Theowns.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mecanicos")
public class MecanicoModel extends PersonaModel {

    @OneToMany(mappedBy="mecanico")
    private ArrayList<EspecialidadModel> especialidades;

    @OneToMany(mappedBy="mecanico")
    private ArrayList<ServicioModel> servicio;

    @OneToMany(mappedBy="mecanico")
    private ArrayList<CalificacionModel> calificacion;

}


