package com.pet.repository;

import com.pet.model.PetDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetDetailsRepo extends JpaRepository<PetDetails,Long> {
}
