package com.pet.shelter.system.service;

import com.pet.shelter.system.Dto.RegistrationDto;
import com.pet.shelter.system.model.UserEntity;

public interface UserService {
    void saveUser(RegistrationDto registrationDto);

    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}
