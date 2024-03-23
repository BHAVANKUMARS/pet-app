package com.pet.service;

import com.pet.dto.LoginDetail;
import com.pet.dto.RegistrationDetail;
import com.pet.model.AdoptionDetails;
import com.pet.model.PetDetails;

import java.util.List;

public interface PetService {

    boolean validateLoginCredentials(LoginDetail loginDetail);

    boolean saveUser(RegistrationDetail registrationDetail);

    List<PetDetails> dashboard();

    PetDetails individualPetProfile(Long petId);

    boolean saveAdoptionDetails(AdoptionDetails adoptionDetails);


}
