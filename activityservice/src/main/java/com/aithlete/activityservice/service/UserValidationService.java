package com.aithlete.activityservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class UserValidationService {

    private  final WebClient userServiceWebClient;

    public boolean validateUser(String userId) throws Exception {

        try {
            return Boolean.TRUE.equals(userServiceWebClient.get().uri("/api/user/{userId}/validate", userId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            throw new Exception("Error in communicating to userservice from activity");
        }


    }

}
