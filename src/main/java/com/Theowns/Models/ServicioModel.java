package com.Theowns.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "servicios")
public class ServicioModel {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    @Getter @Setter
    private String nombreconductor;

    @Column
    @Getter @Setter
    private String nombremecanico;

    @Column
    @Getter @Setter
    private String fecha;


}