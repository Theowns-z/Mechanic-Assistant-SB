package com.Theowns.models;

import com.Theowns.models.enums.Especialidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    @Enumerated(EnumType.STRING)
    private Especialidades tipo;
}
