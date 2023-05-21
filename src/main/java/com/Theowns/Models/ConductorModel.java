package com.Theowns.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Set;

@Entity
@Data
@Table(name="conductores")
public class ConductorModel extends PersonaModel {

    @OneToMany(mappedBy="conductor")
    private ArrayList<VehiculoModel> vehiculos;

    @OneToMany(mappedBy="conductor")
    private ArrayList<ServicioModel> servicios;

}

