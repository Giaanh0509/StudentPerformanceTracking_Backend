package com.example.StudentPerfomanceTracking.dao;


import com.example.StudentPerfomanceTracking.entity.TrackingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:3000")
public interface TrackingDetailsRepository extends JpaRepository<TrackingDetail, Integer> {
    List<TrackingDetail> findByTrackingIdAndIndicatorId(int trackingId, int indicatorId);
    TrackingDetail findByTrackingIdAndIndicatorIdAndStudentId(int trackingId, int indicatorId, int studentId);
    List<TrackingDetail> findByTrackingIdAndStudentId(int trackingId, int studentId);
}
