package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.StudentDTO;
import com.example.StudentPerfomanceTracking.dto.TrackingDTO;
import com.example.StudentPerfomanceTracking.dto.TrackingRequestDTO;
import com.example.StudentPerfomanceTracking.entity.Student;
import com.example.StudentPerfomanceTracking.entity.Tracking;
import com.example.StudentPerfomanceTracking.service.TrackingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trackings")
public class TrackingsController {

    @Autowired
    TrackingsService trackingsService;

    @PostMapping("/new")
    public Tracking createNewTracking(@RequestBody TrackingDTO trackingDTO) {
        return trackingsService.saveTracking(trackingDTO);
    }

    @GetMapping("/objectiveId={objectiveId}")
    public List<TrackingDTO> getTrackingByObjectiveId(@PathVariable int objectiveId) {
        return trackingsService.getTrackingByObjectiveId(objectiveId);
    }

    @PostMapping("/newDetails")
    public void createNewTrackingDetails(@RequestBody TrackingRequestDTO trackingRequestDTO) {
        trackingsService.saveTrackingDetails(trackingRequestDTO);
        return;
    }
}
