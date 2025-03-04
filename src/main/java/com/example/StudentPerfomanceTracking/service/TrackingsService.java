package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.TrackingDTO;
import com.example.StudentPerfomanceTracking.entity.Tracking;

public interface TrackingsService {
    Tracking saveTracking(TrackingDTO trackingDTO);
}
