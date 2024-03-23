package com.pet.service.impl;

import com.pet.dto.LoginDetail;
import com.pet.dto.RegistrationDetail;
import com.pet.model.AdoptionDetails;
import com.pet.model.PetDetails;
import com.pet.model.UserDetails;
import com.pet.repository.PetDetailsRepo;
import com.pet.repository.UserDetailsRepo;
import com.pet.repository.AdoptionDetailsRepo;
import com.pet.service.PetService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @Autowired
    private PetDetailsRepo petDetailsRepo;

    @Autowired
    private AdoptionDetailsRepo adoptionDetailsRepo;

    @Override
    public boolean validateLoginCredentials(LoginDetail loginDetail) {

        Optional<UserDetails> userDetails = userDetailsRepo.findByUserNameAndPassword(loginDetail.getUserName(), loginDetail.getPassword());

        return userDetails.isPresent();

    }

    @Override
    public boolean saveUser(RegistrationDetail registrationDetail) {

        Optional<UserDetails> userDetail = userDetailsRepo.findByUserName(registrationDetail.getUserName());

        if(!userDetail.isPresent()) {

            UserDetails userDetails = new UserDetails();

            BeanUtils.copyProperties(registrationDetail, userDetails);

            return userDetailsRepo.save(userDetails) != null;
        }

        return false;

    }

    @Override
    public List<PetDetails> dashboard() {

        return petDetailsRepo.findAll();

    }

    @Override
    public PetDetails individualPetProfile(Long petId) {

        return petDetailsRepo.findById(petId).get();

    }

    @Override
    public boolean saveAdoptionDetails(AdoptionDetails adoptionDetails) {

        return adoptionDetailsRepo.save(adoptionDetails)!=null;

    }
}
