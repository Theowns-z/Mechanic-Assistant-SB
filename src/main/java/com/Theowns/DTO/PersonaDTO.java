package com.Theowns.DTO;

import com.Theowns.models.ConductorModel;
import com.Theowns.models.PersonaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
    private long id;
    private long cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;


    public static PersonaDTO crearPersonaDTO(PersonaModel persona) {
        return new PersonaDTO(persona.getId(), persona.getCedula(), persona.getNombre(),
                persona.getApellido(), persona.getDireccion(), persona.getTelefono());
    }
}
