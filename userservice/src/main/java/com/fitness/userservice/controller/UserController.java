package com.fitness.userservice.controller;

import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserProfile(

            @PathVariable Long userId
    )
    {
        return  ResponseEntity.ok(userService.getUserProfile(userId));
    }

    @PostMapping("/")
    public ResponseEntity<UserResponse> register(
            @RequestBody RegisterRequest request
    )
    {
        return  ResponseEntity.ok(userService.register(request));
    }


}
