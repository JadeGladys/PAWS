package com.pet.shelter.system.mapper;

import com.pet.shelter.system.Dto.PetDto;
import com.pet.shelter.system.model.Pet;

import java.util.stream.Collectors;

import static com.pet.shelter.system.mapper.ApplicationMapper.mapToApplicationDto;

public class PetMapper {

    public static Pet mapToPet(PetDto pet) {
        Pet petDto = Pet.builder()
                .id(pet.getId())
                .name(pet.getName())
                .type(pet.getType())
                .age(pet.getAge())
                .sex(pet.getSex())
                .breed(pet.getBreed())
                .size(pet.getSize())
                .description(pet.getDescription())
                .imageLink(pet.getImageLink())
                .build();
        return petDto;
    }

    public static PetDto mapToPetDto(Pet pet){
        PetDto petDto = PetDto.builder()
                .id(pet.getId())
                .name(pet.getName())
                .type(pet.getType())
                .age(pet.getAge())
                .sex(pet.getSex())
                .breed(pet.getBreed())
                .size(pet.getSize())
                .description(pet.getDescription())
                .imageLink(pet.getImageLink())
                .applications(pet.getApplications().stream().map((application) -> mapToApplicationDto(application)).collect(Collectors.toList()))
                .build();
        return petDto;
    }

}
