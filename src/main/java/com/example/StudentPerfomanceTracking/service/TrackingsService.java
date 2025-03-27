package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.StudentTrackingUpdateDTO;
import com.example.StudentPerfomanceTracking.dto.TrackingDTO;
import com.example.StudentPerfomanceTracking.dto.TrackingRequestDTO;
import com.example.StudentPerfomanceTracking.entity.Tracking;

import java.util.List;

public interface TrackingsService {
    Tracking saveTracking(TrackingDTO trackingDTO);

    List<TrackingDTO> getTrackingByObjectiveId(int objectiveId);

    void saveTrackingDetails(TrackingRequestDTO trackingRequestDTO);

    boolean checkTracking(int trackingId, int indicatorId);

    List<Double> getTrackingValue(int trackingId, int indicatorId);

    void updateTrackingDetails(int trackingId, int indicatorId, List<StudentTrackingUpdateDTO> studentTrackingUpdateDTOS);

    List<TrackingDTO> getAllTracking();

    Double getTrackingValueStatistics(int trackingId, int indicatorId);

    Double getTrackingValueStudent(int trackingId, int indicatorId, int studentId);
}
