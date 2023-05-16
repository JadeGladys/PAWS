package com.pet.shelter.system.repository;

import com.pet.shelter.system.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findByName(String name);
    List<Pet> findByBreedContainingIgnoreCase(String breed);
    @Query("SELECT c FROM Pet c WHERE c.name LIKE CONCAT('%', :query, '%')")
    List<Pet> searchByName(String query);
}
