package com.pet.shelter.system.service;

import com.pet.shelter.system.model.Volunteer;
import com.pet.shelter.system.repository.VolunteerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerServiceImp implements VolunteerService {
    private final VolunteerRepo volunteerRepo;

    public VolunteerServiceImp(VolunteerRepo volunteerRepo) {
        this.volunteerRepo = volunteerRepo;
    }
    @Override
    public void saveVolunteer(Volunteer volunteer) {
        this.volunteerRepo.save(volunteer);
    }

    @Override
    public List<Volunteer> findAllVolunteers() {
        return volunteerRepo.findAll();
    }

    @Override
    public Volunteer findVolunteerById(String id) {
        return volunteerRepo.findById(id).get();
    }
}
