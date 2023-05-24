package com.Theowns.Repositories;

import com.Theowns.models.ConductorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ConductorRepository extends JpaRepository<ConductorModel, Long> {
}
