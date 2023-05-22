package com.pet.shelter.system.Dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PetDto {
    private long id;
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message = "Type should not be empty")
    private String type;
    private int age;
    @NotEmpty(message = "Sex should not be empty")
    private String sex;
    @NotEmpty(message = "Breed should not be empty")
    private String breed;
    @NotEmpty(message = "Size should not be empty")
    private String size;
    @NotEmpty(message = "Image Link should not be empty")
    private String imageLink;
    private String description;
    private String photoFilename;
    private String photoPath;
    private List<ApplicationDto> applications;
}
