package com.Theowns.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private long id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
}
