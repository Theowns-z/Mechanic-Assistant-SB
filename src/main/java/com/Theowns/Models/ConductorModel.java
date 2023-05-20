package com.Theowns.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name="conductores")
public class ConductorModel {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    @Getter @Setter
    private String nombre;
    @Column
    @Getter @Setter
    private String apellido;
    @Column(unique = true, nullable = false )
    @Getter @Setter
    private long cedula;
    @Column
    @Getter @Setter
    private int edad;
    @Column
    @Getter @Setter
    private String telefono;
    @Column
    @Getter @Setter
    private String direccion;


}

