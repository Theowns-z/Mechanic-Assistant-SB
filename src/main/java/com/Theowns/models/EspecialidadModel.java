package com.Theowns.models;

import com.Theowns.models.enums.Especialidades;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(EspecialidadModelId.class)
@Table(name = "relacion_mec_esp")
public class EspecialidadModel {
    @Id
    @ManyToOne
    @JoinColumn(name = "mecanico_id", nullable = false, unique = false)
    @JsonIgnore
    private MecanicoModel mecanico;

    @Id
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private Especialidades tipo;
}

