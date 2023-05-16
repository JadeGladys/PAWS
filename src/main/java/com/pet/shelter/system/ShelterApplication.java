package com.pet.shelter.system;

import com.pet.shelter.system.controller.PetController;
import com.pet.shelter.system.controller.VolunteerController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class ShelterApplication {
	public static void main(String[] args) {
		new File(VolunteerController.uploadDirectory).mkdir();
		new File(PetController.uploadDirectory).mkdir();
		SpringApplication.run(ShelterApplication.class, args);
	}

}
