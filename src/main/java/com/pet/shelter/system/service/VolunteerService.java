package com.pet.shelter.system.service;

import com.pet.shelter.system.model.Volunteer;

import java.util.List;

public interface VolunteerService {
    void saveVolunteer(Volunteer volunteer);
    List<Volunteer> findAllVolunteers();
    Volunteer findVolunteerById(String id);
}
