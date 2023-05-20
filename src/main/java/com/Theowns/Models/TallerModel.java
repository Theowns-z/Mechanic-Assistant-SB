package com.Theowns.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
@Table(name="talleres")

public class TallerModel {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    @Getter @Setter
    private String nombreempresa;
    @Column
    @Getter @Setter
    private String telefono;
    @Column
    @Getter @Setter
    private String direccion;

}