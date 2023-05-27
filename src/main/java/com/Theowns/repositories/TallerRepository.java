package com.Theowns.repositories;

import com.Theowns.models.TallerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TallerRepository extends JpaRepository<TallerModel,Long> {
}
