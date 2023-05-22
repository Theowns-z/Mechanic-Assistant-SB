package com.Theowns.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "gruas")
public class GruaModel extends EmpresaModel {

    @Column
    private String tipo;

}