package com.Theowns.repositories;

import com.Theowns.models.CalificacionModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalificacionRepository extends JpaRepository<CalificacionModel, Long> {
    List<CalificacionModel> findAllByMecanico_Id(Long id);
    boolean existsByMecanico_Id(Long id);
}
