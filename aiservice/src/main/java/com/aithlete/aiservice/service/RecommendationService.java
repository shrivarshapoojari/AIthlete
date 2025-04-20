package com.aithlete.aiservice.service;


import com.aithlete.aiservice.model.Recommendation;
import com.aithlete.aiservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {


    @Autowired
    private RecommendationRepository recommendationRepository;

    public List<Recommendation> getUserRecommendation(String userId) {

        return  recommendationRepository.findByUserId(userId);
    }

    public List<Recommendation> getActivityRecommendation(String activityId) {



        return  recommendationRepository.findByActivityId(activityId);
    }
}
