package com.pet.shelter.system.repository;

import com.pet.shelter.system.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application, Long> {

}
