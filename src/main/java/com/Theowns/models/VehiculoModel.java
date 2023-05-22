package com.Theowns.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "vehiculos")
public class VehiculoModel {
    @Id
    @Column(unique = true, nullable = false )
    @Getter @Setter
    private  long id;

    @Column(unique = true, nullable = false )
    private String placa;
    @Column
    private String modelo;
    @Column
    private String falla;

    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable = false)
    private ConductorModel conductor;
}