package com.Theowns.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class PersonaModel {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column(unique = true, nullable = false )
    private long cedula;
    @Column
    private String telefono;
    @Column
    private String direccion;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserModel user;

}
