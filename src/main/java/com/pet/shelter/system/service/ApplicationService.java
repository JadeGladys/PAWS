package com.pet.shelter.system.service;

import com.pet.shelter.system.Dto.ApplicationDto;
import com.pet.shelter.system.Dto.PetDto;

import java.util.List;

public interface ApplicationService {
    void createApplication(Long petId, ApplicationDto applicationDto);
    List<ApplicationDto> findAllApplication();
    ApplicationDto findApplicationById(long id);
}
