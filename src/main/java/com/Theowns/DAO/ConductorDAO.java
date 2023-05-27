package com.Theowns.DAO;

import com.Theowns.models.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConductorDAO {

    private long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;

}
