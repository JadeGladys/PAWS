package com.pet.shelter.system.controller;

import com.pet.shelter.system.Dto.ApplicationDto;
import com.pet.shelter.system.model.Application;
import com.pet.shelter.system.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ApplicationController {
    private ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/application/{petId}/new")
    public String createApplicationForm(@PathVariable("petId") Long petId, Model model){
        Application application = new Application();
        model.addAttribute("petId", petId);
        model.addAttribute("application", application);
        return "application";
    }
    @PostMapping("/application/{petId}")
    public String createApplication(@PathVariable("petId") Long petId,
                                    @ModelAttribute("application")ApplicationDto applicationDto, Model model){
        applicationService.createApplication(petId, applicationDto);
        return "redirect:/pets/" + petId;
    }
}
