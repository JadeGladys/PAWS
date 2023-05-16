package com.pet.shelter.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Application {
    @Id
    @SequenceGenerator(
            name = "app_id_sequence",
            sequenceName = "app_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "app_id_sequence"
    )
    private long id;
    private String NID;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String reason;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private Pet pet;
}
