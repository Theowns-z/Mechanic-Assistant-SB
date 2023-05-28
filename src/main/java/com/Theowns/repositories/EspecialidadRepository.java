package com.Theowns.repositories;

import com.Theowns.models.EspecialidadModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EspecialidadRepository extends JpaRepository<EspecialidadModel, Long> {

    @Query("SELECT e FROM especialidadModel e WHERE e.mecanico = :id")
    List<EspecialidadModel> findAllById(@Param("id") Long id);

    boolean existByMecanicoId(Long Id);


}
