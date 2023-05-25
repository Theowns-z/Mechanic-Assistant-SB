package com.Theowns.repositories;

import com.Theowns.models.VehiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoModel,Long> {
}
