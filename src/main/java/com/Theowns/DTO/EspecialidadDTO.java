package com.Theowns.DTO;

import com.Theowns.models.enums.Especialidades;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadDTO {
    int numero_especialidades;
    List<Especialidades> especialidades;
}
