package com.Theowns.repositories;

import com.Theowns.models.EspecialidadModel;
import com.Theowns.models.enums.Especialidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EspecialidadRepository extends JpaRepository<EspecialidadModel, Long> {
    @Query("SELECT e FROM EspecialidadModel e WHERE e.mecanico.id = :mecanicoId")
    List<EspecialidadModel> findByMecanicoId(Long mecanicoId);
    List<EspecialidadModel> findAllByMecanico_Id(Long mecanicoId);
    boolean existsByMecanico_IdAndTipo(Long mecanicoId, Especialidades tipo);
    void removeByMecanico_IdAndTipo(Long mecanicoId, Especialidades tipo);
}
