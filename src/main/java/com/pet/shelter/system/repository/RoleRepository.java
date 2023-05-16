package com.pet.shelter.system.repository;

import com.pet.shelter.system.model.Role;
import com.pet.shelter.system.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
