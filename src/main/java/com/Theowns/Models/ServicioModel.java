package com.Theowns.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.*;

@Entity
@Data
@Table(name = "servicios")
public class ServicioModel {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable = false)
    private ConductorModel conductor;

    @ManyToOne
    @JoinColumn(name = "mecanico_id", nullable = false)
    private MecanicoModel mecanico;

    @Column
    private String fecha;


}