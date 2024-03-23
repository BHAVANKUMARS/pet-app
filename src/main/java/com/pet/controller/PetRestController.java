package com.pet.controller;

import com.pet.model.PetDetails;
import com.pet.repository.PetDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetRestController {

    @Autowired
    private PetDetailsRepo petDetailsRepo;

    @PostMapping("/add-pet")
    public void a(@RequestBody PetDetails petDetails){

        petDetailsRepo.save(petDetails);

    }
}
