package com.pet.shelter.system.repository;

import com.pet.shelter.system.model.Volunteer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolunteerRepo extends JpaRepository<Volunteer, String> {
}
