package com.Theowns.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

enum Especialidades{
    Electricidad,
    Reparaciones,
    Automotriz
}
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "relacion_mec_esp")
public class EspecialidadModel {
    @Id
    @ManyToOne
    @JoinColumn(name = "mecanico_id", nullable = false, unique = false)
    private MecanicoModel mecanico;

    @Column
    private Especialidades tipo;
}
