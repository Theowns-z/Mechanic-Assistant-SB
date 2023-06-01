package com.Theowns.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Table(name = "vehiculos")
public class VehiculoModel {
    @Id
    @Column(unique = true, nullable = false )
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private  long id;
    @Column(unique = true, nullable = false )
    private String placa;
    @Column
    private String modelo;
    @ManyToOne
    @JoinColumn(name = "conductor_id", nullable = false)
    @JsonIgnore
    private ConductorModel conductor;

    @OneToMany(mappedBy="vehiculo")
    @JsonIgnore
    private List<ServicioModel> servicio;
}