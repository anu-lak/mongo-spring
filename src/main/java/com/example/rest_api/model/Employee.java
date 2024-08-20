package com.example.rest_api.model;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @Id
    private int id;
    
    @NotNull(message="Name cannot be null")
    //@NotBlank(message="Name cannot be blank")
    private String name;


    @NotNull(message="Designation cannot be null")
    @Pattern(regexp= "^(account manager||associate)$", message = "Designation have to account manager or associate")
    private String designation;

    @NotNull(message="Designation cannot be null")
    @Pattern(regexp = "^(BA||QA||engineering||sales||delivery)$",message="Invalid department")
    private String department;

    @Email(message ="Invalid email address")
    private String email;

    @Pattern(regexp = "(^\\d{10}$)")
    private String mobile;

    @NotBlank(message = "Location cannot be null")
    private String location;

    //@NotBlank(message = "manager id is required field")
    private int managerId;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime dateOfJoining;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime createdTime;

    private int yearsOfExperience;


}
