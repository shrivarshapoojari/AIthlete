package com.fitness.userservice.dto;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponse {
    private   Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
