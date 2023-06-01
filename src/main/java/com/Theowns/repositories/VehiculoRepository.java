package com.Theowns.repositories;

import com.Theowns.models.VehiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoModel,Long> {

    List<VehiculoModel> findAllByConductor_Id(Long id);
}
