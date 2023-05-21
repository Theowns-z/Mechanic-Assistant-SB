package com.Theowns.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "empresas")
public class EmpresaModel {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nombre;
    @Column
    private String telefono;
    @Column
    private String direccion;
    @Column
    private double coordenada_x;
    @Column
    private double coordenada_y;

}
