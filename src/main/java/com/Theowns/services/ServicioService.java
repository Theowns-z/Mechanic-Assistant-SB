package com.Theowns.services;

import com.Theowns.DTO.ServicioDTO;
import com.Theowns.models.ServicioModel;
import com.Theowns.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioService {

    @Autowired
    ServicioRepository servicioRepository;

    public List<ServicioDTO> getAll() {
        List<ServicioModel> servicios = servicioRepository.findAll();
        List<ServicioDTO> serviciosResponse = new ArrayList<>();

        for (ServicioModel servicio : servicios) {
            ServicioDTO servicioDTO = new ServicioDTO();
            servicioDTO.setServicioDTO(servicio);
            serviciosResponse.add(servicioDTO);
        }

        return serviciosResponse;
    }

    public List<ServicioDTO> getByConductor(Long conductorId) {
        List<ServicioModel> servicios = servicioRepository.findAllByConductor_Id(conductorId);
        List<ServicioDTO> serviciosResponse = new ArrayList<>();

        for (ServicioModel servicio : servicios) {
            ServicioDTO servicioDTO = new ServicioDTO();
            servicioDTO.setServicioDTO(servicio);
            serviciosResponse.add(servicioDTO);
        }
        return serviciosResponse;
    }

    public List<ServicioDTO> getByMecanico(Long mecanicoId) {
        List<ServicioModel> servicios = servicioRepository.findAllByMecanico_Id(mecanicoId);
        List<ServicioDTO> serviciosResponse = new ArrayList<>();

        for (ServicioModel servicio : servicios) {
            ServicioDTO servicioDTO = new ServicioDTO();
            servicioDTO.setServicioDTO(servicio);
            serviciosResponse.add(servicioDTO);
        }
        return serviciosResponse;
    }

    public ServicioDTO save(ServicioModel servicio) {
        servicioRepository.save(servicio);
        ServicioDTO servicioDTO = new ServicioDTO();
        servicioDTO.setServicioDTO(servicio);
        return servicioDTO;
    }

}
