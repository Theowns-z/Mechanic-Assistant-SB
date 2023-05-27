package com.Theowns.repositories;

import com.Theowns.models.MecanicoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MecanicoRepository extends JpaRepository<MecanicoModel, Long> {

    boolean existsByCedula(Long cedula);

}
