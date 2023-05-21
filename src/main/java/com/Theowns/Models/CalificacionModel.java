package com.Theowns.Models;

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
    @ManyToOne
    @JoinColumn(name = "mecanico_id", nullable = false, unique = false)
    private MecanicoModel mecanico;

    @Column
    private int calificacion;
}
