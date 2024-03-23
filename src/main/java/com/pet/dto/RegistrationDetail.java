package com.pet.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegistrationDetail {

    private String userName;

    private String email;

    private String role;

    private String password;

}
