package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.*;
import com.example.StudentPerfomanceTracking.dto.TrackingDTO;
import com.example.StudentPerfomanceTracking.dto.TrackingDetailsDTO;
import com.example.StudentPerfomanceTracking.dto.TrackingRequestDTO;
import com.example.StudentPerfomanceTracking.entity.*;
import com.example.StudentPerfomanceTracking.service.TrackingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TrackingsServiceImpl implements TrackingsService {

    @Autowired
    TrackingsRepository trackingsRepository;

    @Autowired
    ObjectivesRepository objectivesRepository;

    @Autowired
    TrackingDetailsRepository trackingDetailsRepository;

    @Autowired
    StudentsRepository studentsRepository;

    @Autowired
    IndicatorsRepository indicatorsRepository;

    @Override
    public Tracking saveTracking(TrackingDTO trackingDTO) {
        Objective objective = objectivesRepository.findObjectiveById(trackingDTO.getObjectiveId());
        Tracking tracking;
        tracking = new Tracking(trackingDTO.getName(), trackingDTO.getCreateDate(), objective);
        trackingsRepository.save(tracking);
        return tracking;
    }

    @Override
    public List<TrackingDTO> getTrackingByObjectiveId(int objectiveId) {
        List<Tracking> trackingList = trackingsRepository.findByObjectiveId(objectiveId);
        List<TrackingDTO> trackingDTOList = new ArrayList<>();

        for(Tracking tracking: trackingList) {
            TrackingDTO trackingDTO = new TrackingDTO(
                    tracking.getId(),
                    tracking.getName(),
                    tracking.getCreateDate(),
                    tracking.getObjective().getId());

            trackingDTOList.add(trackingDTO);
        }

        return trackingDTOList;
    }

    @Override
    public void saveTrackingDetails(TrackingRequestDTO trackingRequestDTO) {

        if (trackingRequestDTO == null || trackingRequestDTO.getTrackingDTOList() == null) {
            throw new IllegalArgumentException("TrackingDTO list cannot be null");
        }

        Tracking tracking = trackingsRepository.findTrackingById(trackingRequestDTO.getTrackingId());
        Indicator indicator = indicatorsRepository.findById(trackingRequestDTO.getIndicatorId());
        String trackingDate = trackingRequestDTO.getTrackingDate();

        for(TrackingDetailsDTO trackingDetailsDTO: trackingRequestDTO.getTrackingDTOList()) {
            Student student = studentsRepository.findStudentById(trackingDetailsDTO.getStudentId());
            TrackingDetail trackingDetail = new TrackingDetail(
                    trackingDetailsDTO.getTrackingValue(),
                    trackingDate,
                    student,
                    tracking,
                    indicator);


            trackingDetailsRepository.save(trackingDetail);
        }
    }
}
