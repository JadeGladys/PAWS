package com.pet.shelter.system.service;

import com.pet.shelter.system.Dto.ApplicationDto;
import com.pet.shelter.system.model.Application;
import com.pet.shelter.system.model.Pet;
import com.pet.shelter.system.repository.ApplicationRepo;
import com.pet.shelter.system.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.pet.shelter.system.mapper.ApplicationMapper.mapToApplication;
import static com.pet.shelter.system.mapper.ApplicationMapper.mapToApplicationDto;
import static com.pet.shelter.system.mapper.PetMapper.mapToPetDto;

@Service
public class ApplicationServiceImp implements ApplicationService{
    private ApplicationRepo applicationRepo;
    private PetRepository petRepository;

    @Autowired
    public ApplicationServiceImp(ApplicationRepo applicationRepo, PetRepository petRepository) {
        this.applicationRepo = applicationRepo;
        this.petRepository = petRepository;
    }

    @Override
    public void createApplication(Long petId, ApplicationDto applicationDto) {
        Pet pet = petRepository.findById(petId).get();
        Application application = mapToApplication(applicationDto);
        application.setPet(pet);
        applicationRepo.save(application);
    }

    @Override
    public List<ApplicationDto> findAllApplication() {
        List<Application> applications = applicationRepo.findAll();
        return applications.stream().map((application) -> mapToApplicationDto(application)).collect(Collectors.toList());
    }

    @Override
    public ApplicationDto findApplicationById(long id) {
        Application application = applicationRepo.findById(id).get();
        return mapToApplicationDto(application);
    }
}
