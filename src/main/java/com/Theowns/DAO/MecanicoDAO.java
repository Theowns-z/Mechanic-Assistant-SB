package com.Theowns.DAO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MecanicoDAO {

    private long id;
    private String nombre;
    private String apellido;

    private String telefono;
    private String direccion;



}
