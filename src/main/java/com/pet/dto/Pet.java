package com.pet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Pet {

    private Long id;

    private String imagePath;

    private String name;

    private int age;

    public Pet(Long id, String name, int age,String imagePath) {
        this.id = id;
        this.imagePath = imagePath;
        this.name = name;
        this.age = age;
    }
}
