package com.pet.shelter.system.service;

import com.pet.shelter.system.Dto.PetDto;
import com.pet.shelter.system.model.Pet;
import com.pet.shelter.system.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.pet.shelter.system.mapper.PetMapper.mapToPet;
import static com.pet.shelter.system.mapper.PetMapper.mapToPetDto;

@Service
public class PetServiceImp implements PetService{
    private PetRepository petRepository;

    @Autowired
    public PetServiceImp(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<PetDto> findAllPets() {
        List<Pet> pets = petRepository.findAll();
        return pets.stream().map((pet) -> mapToPetDto(pet)).collect(Collectors.toList());
    }

    @Override
    public Pet savePet(PetDto petDto) {
        Pet pet = mapToPet(petDto);
        return petRepository.save(pet);
    }

    @Override
    public void updatePet(PetDto petDto) {
        Pet pet = mapToPet(petDto);
        petRepository.save(pet);
    }

    @Override
    public PetDto findPetById(long id) {
        Pet pet = petRepository.findById(id).get();
        return mapToPetDto(pet);
    }

    @Override
    public void deletePetById(long id) {
        petRepository.deleteById(id);
    }

    @Override
    public List<PetDto> searchPets(String query) {
        List<Pet> pets = petRepository.searchByName(query);
        return pets.stream().map(pet -> mapToPetDto(pet)).collect(Collectors.toList());
    }

    @Override
    public List<Pet> findPetsByBreed(String breed) {
        return petRepository.findByBreedContainingIgnoreCase(breed);
    }
}
