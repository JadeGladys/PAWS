package com.pet.shelter.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Volunteeres")
public class Volunteer {
    @Id
    private String nid;
    private String fullName;
    private String phone;
    private String email;
    private String levelOfCommitment;
}
