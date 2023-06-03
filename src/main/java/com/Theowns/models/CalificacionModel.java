package com.Theowns.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "calificacion_mecanico")
public class CalificacionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "mecanico_id", nullable = false, unique = false)
    @JsonIgnore
    private MecanicoModel mecanico;
    @Column(nullable = false,unique = false)
    private double calificacion;
}
