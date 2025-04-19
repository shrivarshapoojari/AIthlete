package com.fitness.userservice.service;


import com.fitness.userservice.dto.RegisterRequest;
import com.fitness.userservice.dto.UserResponse;
import com.fitness.userservice.model.User;
import com.fitness.userservice.model.UserRole;
import com.fitness.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    
    public UserResponse register(RegisterRequest request)
    {
        if(userRepository.existsByEmail(request.getEmail()))
        {
                throw  new RuntimeException("User already exists");
        }
        User user=new User();
        user.setEmail(request.getEmail());

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        
        
       User savedUser= userRepository.save(user);
        
       UserResponse response=new UserResponse();
       response.setEmail(savedUser.getEmail());
       response.setFirstName(savedUser.getFirstName());
       response.setLastName(savedUser.getLastName());
       response.setId(savedUser.getId());
       response.setCreatedAt(savedUser.getCreatedAt());
       response.setUpdatedAt(savedUser.getUpdatedAt());
       return response;
    }
    
    public  UserResponse getUserProfile(Long userId)
    {
        User savedUser=userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("user not found"));


        UserResponse response=new UserResponse();
        response.setEmail(savedUser.getEmail());
        response.setFirstName(savedUser.getFirstName());
        response.setLastName(savedUser.getLastName());
        response.setId(savedUser.getId());
        response.setCreatedAt(savedUser.getCreatedAt());
        response.setUpdatedAt(savedUser.getUpdatedAt());
        return response;

    }

    public Boolean existByUserId(Long userId) {

        return  userRepository.existsById(userId);
    }
}
