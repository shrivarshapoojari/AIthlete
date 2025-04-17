package com.fitness.userservice.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Email is required")
    private  String email;
    @NotBlank(message = "password is required")
    private String password;
    @NotBlank(message = "firstname is required")
    private  String firstName;
    @NotBlank(message = "lastname is required")
    private String lastName;
}
