package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.*;
import com.example.StudentPerfomanceTracking.dto.*;
import com.example.StudentPerfomanceTracking.entity.*;
import com.example.StudentPerfomanceTracking.service.TrackingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    SkillsRepository skillsRepository;

    @Autowired
    SubjectsRepository subjectsRepository;

    @Override
    public Tracking saveTracking(TrackingDTO trackingDTO) {
        Objective objective = objectivesRepository.findObjectiveById(trackingDTO.getObjectiveId());
        Tracking tracking;
        tracking = new Tracking(trackingDTO.getName(),
                trackingDTO.getCreateDate(),
                trackingDTO.getTrackingDate(),
                trackingDTO.getDescription(),
                objective);
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
                    tracking.getTrackingDate(),
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

    @Override
    public boolean checkTracking(int trackingId, int indicatorId) {
        List<TrackingDetail> detail = trackingDetailsRepository.findByTrackingIdAndIndicatorId(trackingId, indicatorId);
        if (detail.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<Double> getTrackingValue(int trackingId, int indicatorId) {
        List<TrackingDetail> detail = trackingDetailsRepository.findByTrackingIdAndIndicatorId(trackingId, indicatorId);
        List<Double> doubleList = new ArrayList<>();
        for (TrackingDetail trackingDetail : detail) {
            doubleList.add(trackingDetail.getTrackingValue());
        }
        return doubleList;
    }

    @Override
    public void updateTrackingDetails(int trackingId, int indicatorId, List<StudentTrackingUpdateDTO> studentTrackingUpdateDTOS) {
        List<TrackingDetail> details = trackingDetailsRepository.findByTrackingIdAndIndicatorId(trackingId, indicatorId);

        for(StudentTrackingUpdateDTO studentTrackingUpdateDTO: studentTrackingUpdateDTOS) {
            for (TrackingDetail trackingDetail : details) {
                if (studentTrackingUpdateDTO.getId() == trackingDetail.getStudent().getId()) {
                    trackingDetail.setTrackingValue(studentTrackingUpdateDTO.getTrackingValue());
                    trackingDetailsRepository.save(trackingDetail);
                }
            }
        }

    }

    @Override
    public List<TrackingDTO> getAllTracking() {
        List<Tracking> trackingList = trackingsRepository.findAll();
        List<TrackingDTO> trackingDTOList = new ArrayList<>();

        for(Tracking tracking: trackingList) {
            TrackingDTO trackingDTO = new TrackingDTO(
                    tracking.getId(),
                    tracking.getName(),
                    tracking.getCreateDate(),
                    tracking.getTrackingDate(),
                    tracking.getObjective().getId());

            trackingDTOList.add(trackingDTO);
        }

        return trackingDTOList;
    }

    @Override
    public Double getTrackingValueStatistics(int trackingId, int indicatorId) {
        List<TrackingDetail> detail = trackingDetailsRepository.findByTrackingIdAndIndicatorId(trackingId, indicatorId);
        List<Double> doubleList = detail.stream()
                .map(TrackingDetail::getTrackingValue)
                .collect(Collectors.toList());

        return doubleList.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);
    }

    @Override
    public Double getTrackingValueStudent(int trackingId, int indicatorId, int studentId) {
        TrackingDetail detail = trackingDetailsRepository.findByTrackingIdAndIndicatorIdAndStudentId(trackingId, indicatorId, studentId);
        if(detail == null) {
            return 0.0;
        } else return detail.getTrackingValue();
    }

    @Override
    public AchievementDTO getAchievement(int objectiveId, int trackingId, int studentId) {
        Tracking tracking = trackingsRepository.findTrackingById(trackingId);
        double averagePoint = 0;
        double totalPoint = 0;
        double sumSkill = 0;

        AchievementDTO achievementDTO = new AchievementDTO();
        achievementDTO.setTrackingId(trackingId);
        achievementDTO.setTrackingName(tracking.getName());
        achievementDTO.setTrackingDate(tracking.getTrackingDate());
        List<ScoreDTO> scoreDTOList = new ArrayList<>();
        List<TrackingDetail> trackingDetails = trackingDetailsRepository.findByTrackingIdAndStudentId(trackingId, studentId);
        for (TrackingDetail trackingDetail: trackingDetails) {
            ScoreDTO scoreDTO = new ScoreDTO(trackingDetail.getIndicator().getSkill().getName(), trackingDetail.getIndicator().getEvaluationType(), trackingDetail.getTrackingValue(), trackingDetail.getIndicator().getScaleMax());
            totalPoint += trackingDetail.getTrackingValue();
            sumSkill += trackingDetail.getIndicator().getSkill().getFormula();
            scoreDTOList.add(scoreDTO);
        }

        averagePoint = totalPoint/sumSkill;
        double rounded = BigDecimal.valueOf(averagePoint)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        achievementDTO.setAveragePoint(rounded);
        achievementDTO.setScoreDTOList(scoreDTOList);
        return achievementDTO;
    }

    @Override
    public double calculateScore(int objectiveId, int studentId) {
        return 0;
    }

    @Override
    public void deleteTracking(int trackingId) {
        trackingsRepository.deleteTrackingById(trackingId);
    }
}
