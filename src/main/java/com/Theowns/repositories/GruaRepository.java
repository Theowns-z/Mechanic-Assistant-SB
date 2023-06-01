package com.Theowns.repositories;

import com.Theowns.models.GruaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GruaRepository extends JpaRepository<GruaModel,Long> {



}
