package com.Theowns.models;

import com.Theowns.models.enums.Especialidades;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class EspecialidadModelId implements Serializable {
    private MecanicoModel mecanico;
    private Especialidades tipo;
}
