package com.pet.shelter.system.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationDto {
    private long id;
    private String NID;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String reason;
}
