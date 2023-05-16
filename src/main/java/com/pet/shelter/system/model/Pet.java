package com.pet.shelter.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String type;
    private int age;
    private String sex;
    private String breed;
    private String size;
    private String imageLink;
    private String description;
    private String photoFilename;
    private String photoPath;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.REMOVE)
    private final List<Application> applications = new ArrayList<>();
}
