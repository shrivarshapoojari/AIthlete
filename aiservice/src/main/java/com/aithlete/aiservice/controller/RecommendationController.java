package com.aithlete.aiservice.controller;

import com.aithlete.aiservice.model.Recommendation;
import com.aithlete.aiservice.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recommend")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable String userId)
    {

        return  ResponseEntity.ok(recommendationService.getUserRecommendation(userId));
    }


       @GetMapping("/user/{activityId}")
    public ResponseEntity<List<Recommendation>> getActivityRecommendation(@PathVariable String activityId)
    {

        return  ResponseEntity.ok(recommendationService.getActivityRecommendation(activityId));
    }




}
