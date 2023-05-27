package com.Theowns.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name="conductores")
public class ConductorModel extends PersonaModel {

    @OneToMany(mappedBy="conductor")
    @JsonIgnore
    private List<VehiculoModel> vehiculos;

    @OneToMany(mappedBy="conductor")
    @JsonIgnore
    private List<ServicioModel> servicios;

}

