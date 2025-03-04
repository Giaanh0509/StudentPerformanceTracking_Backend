package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.StudentDTO;
import com.example.StudentPerfomanceTracking.dto.TrackingDTO;
import com.example.StudentPerfomanceTracking.entity.Student;
import com.example.StudentPerfomanceTracking.entity.Tracking;
import com.example.StudentPerfomanceTracking.service.TrackingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trackings")
public class TrackingsController {

    @Autowired
    TrackingsService trackingsService;

    @PostMapping("/new")
    public Tracking createNewStudent(@RequestBody TrackingDTO trackingDTO) {
        return trackingsService.saveTracking(trackingDTO);
    }
}
