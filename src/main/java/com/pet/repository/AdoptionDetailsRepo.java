package com.pet.repository;

import com.pet.model.AdoptionDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptionDetailsRepo extends JpaRepository<AdoptionDetails,Long> {
}
