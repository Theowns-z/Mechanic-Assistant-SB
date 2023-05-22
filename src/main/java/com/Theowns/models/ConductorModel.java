package com.Theowns.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
@Table(name="conductores")
public class ConductorModel extends PersonaModel {

    @OneToMany(mappedBy="conductor")
    private ArrayList<VehiculoModel> vehiculos;

    @OneToMany(mappedBy="conductor")
    private ArrayList<ServicioModel> servicios;

}

