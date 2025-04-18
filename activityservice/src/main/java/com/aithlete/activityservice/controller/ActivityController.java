package com.aithlete.activityservice.controller;

import com.aithlete.activityservice.dto.ActivityRequest;
import com.aithlete.activityservice.dto.ActivityResponse;
import com.aithlete.activityservice.model.Activity;
import com.aithlete.activityservice.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping()
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request)
    {
        return  ResponseEntity.ok(activityService.trackActivity(request));

    }
    @GetMapping("/user/{userId}")
    public  ResponseEntity<List<Activity>>getUserActivity(
            @PathVariable String userId


    )
    {
        return  ResponseEntity.ok(activityService.getUserActivity(userId));
    }

    @GetMapping("/activity/{activityId}")
    public  ResponseEntity<Activity>getActivity(
            @PathVariable String activityId


    )
    {
        return  ResponseEntity.ok(activityService.getActivity(activityId));
    }
}
