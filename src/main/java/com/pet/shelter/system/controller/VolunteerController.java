package com.pet.shelter.system.controller;

import com.pet.shelter.system.Dto.ApplicationDto;
import com.pet.shelter.system.model.Volunteer;
import com.pet.shelter.system.service.VolunteerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class VolunteerController {
    private VolunteerService volunteerService;

    public VolunteerController(VolunteerService volunteerService) {
        this.volunteerService = volunteerService;
    }

    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/java/imagedata";

    //bind data to volunteer page
    @GetMapping("/volunteer")
    public String showShelterPage(Model model) {
        //create model attribute to bind form data
        Volunteer volunteer = new Volunteer();
        model.addAttribute("volunteer", volunteer);
        return "volunteer";
    }

    @PostMapping("/saveVolunteer")
    public String saveVolunteer(@ModelAttribute("volunteer") @Valid Volunteer volunteer, BindingResult result,
                                @RequestParam("photo") MultipartFile file) {
        if (result.hasErrors()) {
            // Handle validation errors
            return "error";
        }

        if (!file.isEmpty()) {
            try {
                String filename = volunteer.getNid() + file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4);
                Path filePath = Paths.get(uploadDirectory, filename);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                volunteer.setPhotoFilename(filename);
                volunteer.setPhotoPath(filePath.toString());
            } catch (IOException e) {
                // Handle the exception
            }
        }

        volunteerService.saveVolunteer(volunteer);
        return "redirect:/volunteer";
    }

    @GetMapping("/volunteers/{id}")
    public String applicationDetails(@PathVariable("id") String id, Model model){
        Volunteer volunteer = volunteerService.findVolunteerById(id);
        model.addAttribute("volunteer", volunteer);
        return "viewvolunteer";
    }
}
