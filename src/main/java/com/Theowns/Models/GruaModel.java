package com.Theowns.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "gruas")
public class GruaModel extends EmpresaModel {

    @Column
    private String tipo;

}