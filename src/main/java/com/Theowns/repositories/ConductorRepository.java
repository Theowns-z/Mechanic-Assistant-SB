package com.Theowns.repositories;

import com.Theowns.models.ConductorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ConductorRepository extends JpaRepository<ConductorModel, Long> {
}
