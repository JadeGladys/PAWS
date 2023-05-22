package com.pet.shelter.system.controller;

import com.pet.shelter.system.Dto.ApplicationDto;
import com.pet.shelter.system.Dto.PetDto;
import com.pet.shelter.system.model.Pet;
import com.pet.shelter.system.model.Volunteer;
import com.pet.shelter.system.service.ApplicationService;
import com.pet.shelter.system.service.PetService;
import com.pet.shelter.system.service.VolunteerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.List;

@Controller
public class PetController {
    private final PetService petService;
    private final ApplicationService applicationService;
    private final VolunteerService volunteerService;

    @Autowired
    public PetController(PetService petService, ApplicationService applicationService, VolunteerService volunteerService) {
        this.petService = petService;
        this.applicationService = applicationService;
        this.volunteerService = volunteerService;
    }
    public static String uploadDirectory = System.getProperty("user.dir") + "/src/main/java/imagedata";

    @GetMapping("/pets")
    public String listPets(Model model){
        List<PetDto> pets = petService.findAllPets();
        model.addAttribute("listPets", pets);
        return "shelter";
    }

    @GetMapping("/admin")
    public String listPetsForAdmin(Model model){
        List<PetDto> pets = petService.findAllPets();
        List<ApplicationDto> application = applicationService.findAllApplication();
        List<Volunteer> volunteers = volunteerService.findAllVolunteers();
        model.addAttribute("listPets", pets);
        model.addAttribute("list", application);
        model.addAttribute("volunteers", volunteers);
        return "admin";
    }

    @GetMapping("/pets/new")
    public String CreatePetForm(Model model){
        Pet pet = new Pet();
        model.addAttribute("pet", pet);
        return "create_pet";
    }

    @GetMapping("/pets/{id}")
    public String petDetails(@PathVariable("id") long id, Model model){
        PetDto petDto = petService.findPetById(id);
        model.addAttribute("pet", petDto);
        return "viewpets";
    }
    @GetMapping("/applications/{id}")
    public String applicationDetails(@PathVariable("id") long id, Model model){
        ApplicationDto applicationDto = applicationService.findApplicationById(id);
        model.addAttribute("adopt", applicationDto);
        return "viewapplication";
    }

    @PostMapping("/pets/new")
    public String savePet(@Valid @ModelAttribute("pet") PetDto petDto,
                          BindingResult result, Model model, @RequestParam("photo") MultipartFile file){
        if(result.hasErrors()){
            model.addAttribute("pet", petDto);
            return "create_pet";
        }
        if (!file.isEmpty()) {
            try {
                String filename = petDto.getId() + file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4);
                Path filePath = Paths.get(uploadDirectory, filename);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                petDto.setPhotoFilename(filename);
                petDto.setPhotoPath(filePath.toString());
            } catch (IOException e) {
            }
        }
        petService.savePet(petDto);
        return "redirect:/pets";
    }

    @GetMapping("/pet/{id}/edit")
    public String editPetForm(@PathVariable("id") long id, Model model){
        PetDto petDto = petService.findPetById(id);
        model.addAttribute("pet", petDto);
        return "edit_pet";
    }

    @PostMapping("/pets/{id}/update")
    public String updatePet(@PathVariable("id") long id,
                            @Valid @ModelAttribute("pet") PetDto petDto,
                            BindingResult result){
        if(result.hasErrors()){
            return "edit_pet";
        }
        petDto.setId(id);
        petService.updatePet(petDto);
        return "redirect:/admin";
    }

    @GetMapping("/pets/{id}/delete")
    public String deletePet(@PathVariable("id") long id){
        petService.deletePetById(id);
        return "redirect:/admin";
    }

    @GetMapping("/pets/search")
    public String searchPage(Model model){
        return "search-results";
    }
    @GetMapping("/contact")
    public String contactPage(Model model){
        return "contact";
    }

    @PostMapping("/pets/search")
    public String searchByBreed(@RequestParam("breed") String breed, Model model) {
        List<Pet> pets = petService.findPetsByBreed(breed);
        model.addAttribute("pets", pets);
        return "search-results";
    }


}
