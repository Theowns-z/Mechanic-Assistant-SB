package com.Theowns.repositories;

import com.Theowns.models.ServicioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<ServicioModel, Long> {

    List<ServicioModel> findAllByConductor_Id(Long id);
    List<ServicioModel> findAllByMecanico_Id(Long id);
}
