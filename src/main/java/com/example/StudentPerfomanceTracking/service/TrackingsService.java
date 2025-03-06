package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.TrackingDTO;
import com.example.StudentPerfomanceTracking.dto.TrackingRequestDTO;
import com.example.StudentPerfomanceTracking.entity.Tracking;

import java.util.List;

public interface TrackingsService {
    Tracking saveTracking(TrackingDTO trackingDTO);

    List<TrackingDTO> getTrackingByObjectiveId(int objectiveId);

    void saveTrackingDetails(TrackingRequestDTO trackingRequestDTO);
}
