package com.pet.shelter.system.mapper;

import com.pet.shelter.system.Dto.ApplicationDto;
import com.pet.shelter.system.model.Application;

public class ApplicationMapper {

    public static Application mapToApplication(ApplicationDto applicationDto){
        return Application.builder()
                .id(applicationDto.getId())
                .NID(applicationDto.getNID())
                .firstName(applicationDto.getFirstName())
                .lastName(applicationDto.getLastName())
                .phone(applicationDto.getPhone())
                .email(applicationDto.getEmail())
                .reason(applicationDto.getReason())
                .build();
    }
    public static ApplicationDto mapToApplicationDto(Application application){
        return ApplicationDto.builder()
                .id(application.getId())
                .NID(application.getNID())
                .firstName(application.getFirstName())
                .lastName(application.getLastName())
                .phone(application.getPhone())
                .email(application.getEmail())
                .reason(application.getReason())
                .build();
    }
}
