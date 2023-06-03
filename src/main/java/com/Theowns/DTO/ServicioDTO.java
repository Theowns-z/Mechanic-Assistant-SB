package com.Theowns.DTO;

import com.Theowns.models.ConductorModel;
import com.Theowns.models.MecanicoModel;
import com.Theowns.models.ServicioModel;
import com.Theowns.models.VehiculoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDTO {
    private long id;
    private PersonaDTO conductor;
    private PersonaDTO mecanico;
    private VehiculoModel vehiculo;
    private String descripcion;
    private String fecha;

    public void setServicioDTO(ServicioModel servicioModel) {
        this.id = servicioModel.getId();
        this.conductor = PersonaDTO.crearPersonaDTO(servicioModel.getConductor());
        this.mecanico = PersonaDTO.crearPersonaDTO(servicioModel.getMecanico());
        this.vehiculo = servicioModel.getVehiculo();
        this.descripcion = servicioModel.getDescripcion();
        this.fecha = servicioModel.getFecha();
    }
}
