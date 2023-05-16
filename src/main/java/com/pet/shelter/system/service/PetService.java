package com.pet.shelter.system.service;

import com.pet.shelter.system.Dto.PetDto;
import com.pet.shelter.system.model.Pet;

import java.util.List;

public interface PetService {
    List<PetDto> findAllPets();
    Pet savePet(PetDto petDto);
    void updatePet(PetDto petDto);

    PetDto findPetById(long id);

    void deletePetById(long id);
    List<PetDto> searchPets(String query);
    List<Pet> findPetsByBreed(String breed);
}
