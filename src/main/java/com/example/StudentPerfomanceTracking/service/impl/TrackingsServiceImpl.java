package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.ObjectivesRepository;
import com.example.StudentPerfomanceTracking.dao.TrackingsRepository;
import com.example.StudentPerfomanceTracking.dto.TrackingDTO;
import com.example.StudentPerfomanceTracking.entity.Objective;
import com.example.StudentPerfomanceTracking.entity.Tracking;
import com.example.StudentPerfomanceTracking.service.TrackingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TrackingsServiceImpl implements TrackingsService {

    @Autowired
    TrackingsRepository trackingsRepository;

    @Autowired
    ObjectivesRepository objectivesRepository;

    @Override
    public Tracking saveTracking(TrackingDTO trackingDTO) {
        Objective objective = objectivesRepository.findObjectiveById(trackingDTO.getObjectiveId());
        Tracking tracking = new Tracking(trackingDTO.getName(), trackingDTO.getCreateDate(), objective);
        return null;
    }
}
