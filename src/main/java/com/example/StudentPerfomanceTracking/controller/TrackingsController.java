package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.*;
import com.example.StudentPerfomanceTracking.entity.Student;
import com.example.StudentPerfomanceTracking.entity.Subject;
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

    @GetMapping("/all")
    public List<TrackingDTO> getAllTracking() {
        return trackingsService.getAllTracking();
    }

    @GetMapping("/objectiveId={objectiveId}")
    public List<TrackingDTO> getTrackingByObjectiveId(@PathVariable int objectiveId) {
        return trackingsService.getTrackingByObjectiveId(objectiveId);
    }

    @GetMapping("/trackingId={trackingId}/indicatorId={indicatorId}")
    public List<Double> getTrackingValue(@PathVariable("trackingId") int trackingId,
                                         @PathVariable("indicatorId") int indicatorId) {
        return trackingsService.getTrackingValue(trackingId, indicatorId);
    }

    @GetMapping("/trackingId={trackingId}/indicatorId={indicatorId}/statistics")
    public Double getTrackingValueAllStudent(@PathVariable("trackingId") int trackingId,
                                             @PathVariable("indicatorId") int indicatorId) {
        return trackingsService.getTrackingValueStatistics(trackingId, indicatorId);
    }

    @GetMapping("/trackingId={trackingId}/indicatorId={indicatorId}/studentId={studentId}")
    public Double getTrackingValueStudent(@PathVariable("trackingId") int trackingId,
                                             @PathVariable("indicatorId") int indicatorId,
                                             @PathVariable("studentId") int studentId) {
        return trackingsService.getTrackingValueStudent(trackingId, indicatorId, studentId);
    }

    @PostMapping("/newDetails")
    public void createNewTrackingDetails(@RequestBody TrackingRequestDTO trackingRequestDTO) {
        trackingsService.saveTrackingDetails(trackingRequestDTO);
        return;
    }

    @GetMapping("/{trackingId}/indicators/{indicatorId}/exists")
    public boolean checkTracking(@PathVariable("trackingId") int trackingId,
                                 @PathVariable("indicatorId") int indicatorId) {
        return trackingsService.checkTracking(trackingId, indicatorId);
    }

    @PutMapping("details/update/{trackingId}/{indicatorId}")
    public void updateTrackingDetails(@PathVariable("trackingId") int trackingId,
                                      @PathVariable("indicatorId") int indicatorId,
                                      @RequestBody List<StudentTrackingUpdateDTO> studentTrackingUpdateDTOS) {
        trackingsService.updateTrackingDetails(trackingId, indicatorId, studentTrackingUpdateDTOS);
        return;
    }
}
