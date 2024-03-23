package com.pet.controller;

import com.pet.dto.LoginDetail;
import com.pet.dto.RegistrationDetail;
import com.pet.model.AdoptionDetails;
import com.pet.model.PetDetails;
import com.pet.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("loginDetail",new LoginDetail());

        return "index";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginDetail") LoginDetail loginDetail ,Model model){

        System.out.println("login request "+loginDetail);

        boolean isUserExist = petService.validateLoginCredentials(loginDetail);

        if(isUserExist){
            return "redirect:/dashboard";
        }

        model.addAttribute("errorMsg","Invalid Credential");

        return "index";


    }

    @GetMapping("/register")
    public String register(Model model){

        model.addAttribute("registerDetail",new RegistrationDetail());

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("registerDetail") RegistrationDetail registrationDetail , Model model){

        System.out.println("request  ="+registrationDetail);

        boolean isUserRegister = petService.saveUser(registrationDetail);

        if(isUserRegister){
            model.addAttribute("msg","Registered Successfully");
        }else{
            model.addAttribute("errorMsg","Enter Unique UserName");
        }

        return "register";

    }

    @GetMapping("/dashboard")
    public String dashboard(Model model){

        List<PetDetails> pets = petService.dashboard();

        pets.forEach(petDetails -> System.out.println(petDetails));

        model.addAttribute("pets", pets);

        return "dashboard";

    }

    @GetMapping("/profile-api")
    public String a(@RequestParam("petId") Long petId,Model model){

        System.out.println("petId "+petId);

        PetDetails petDetails = petService.individualPetProfile(petId);

        model.addAttribute("petDetails",petDetails);

        return "profile";


    }

    @GetMapping("/adoptionForm")
    public String adoptionForm(Model model){

        model.addAttribute("adoptionDetail",new AdoptionDetails());

        return "adoptionForm";
    }

    @PostMapping("/submit-adoption")
    public String submitAdoption(@ModelAttribute ("adoptionDetail")AdoptionDetails adoptionDetails,Model model){

        petService.saveAdoptionDetails(adoptionDetails);

        model.addAttribute("msg","Thanks For Adoption");

        return "adoptionForm";

    }



}
