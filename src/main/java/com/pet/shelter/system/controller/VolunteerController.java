package com.pet.shelter.system.controller;

import com.pet.shelter.system.model.Volunteer;
import com.pet.shelter.system.service.VolunteerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VolunteerController {
    private VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    //bind data to volunteer page
    @GetMapping("/volunteer")
    public String showShelterPage(Model model) {
        //create model attribute to bind form data
        Volunteer volunteer = new Volunteer();
        model.addAttribute("volunteer", volunteer);
        return "volunteer";
    }

    @PostMapping("/saveVolunteer")
    public String saveVolunteer(@ModelAttribute("volunteer")Volunteer volunteer){
        volunteerService.saveVolunteer(volunteer);
        return "redirect:/volunteer";
    }
}
