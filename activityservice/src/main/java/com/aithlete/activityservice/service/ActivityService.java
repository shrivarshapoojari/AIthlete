package com.aithlete.activityservice.service;


import com.aithlete.activityservice.dto.ActivityRequest;
import com.aithlete.activityservice.dto.ActivityResponse;
import com.aithlete.activityservice.model.Activity;
import com.aithlete.activityservice.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {


    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private  UserValidationService userValidationService;

    public ActivityResponse trackActivity(ActivityRequest request) throws Exception {

        boolean isValidUser=userValidationService.

                validateUser(request.getUserId());




        Activity activity=Activity.builder().
                            userId(request.getUserId())
                .type(request.getActivityType())
                .duration(request.getDuration())
                .startTime(request.getStartTime())
                .caloriesBurned(request.getCaloriesBurned())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();

        Activity savedActivity=activityRepository.save(activity);



      return  mapToResponse(savedActivity);

    }
    private ActivityResponse mapToResponse(Activity activity) {
        ActivityResponse response = new ActivityResponse();
        response.setId(activity.getId());
        response.setUserId(activity.getUserId());
        response.setType(activity.getType());
        response.setDuration(activity.getDuration());
        response.setCaloriesBurned(activity.getCaloriesBurned());
        response.setStartTime(activity.getStartTime());
        response.setAdditionalMetrics(activity.getAdditionalMetrics());
        response.setCreatedAt(activity.getCreatedAt());
        response.setUpdatedAt(activity.getUpdatedAt());
        return response;
    }

    public List<Activity> getUserActivity(String userId) {


        return  activityRepository.findByUserId(userId);

    }

    public Activity getActivity(String activityId) {

        return  activityRepository.findById(activityId).orElseThrow(()->new RuntimeException("Not found"));
    }
}
