package com.example.StudentPerfomanceTracking.dto;

import java.util.List;

public class AchievementDTO {

    private int trackingId;
    private String trackingName;

    private String trackingDate;

    private double averagePoint;

    private List<ScoreDTO> scoreDTOList;

    public AchievementDTO() {
    }

    public AchievementDTO(String trackingName, String trackingDate, List<ScoreDTO> scoreDTOList, double averagePoint) {
        this.trackingName = trackingName;
        this.trackingDate = trackingDate;
        this.scoreDTOList = scoreDTOList;
        this.averagePoint = averagePoint;
    }

    public String getTrackingName() {
        return trackingName;
    }

    public void setTrackingName(String trackingName) {
        this.trackingName = trackingName;
    }

    public String getTrackingDate() {
        return trackingDate;
    }

    public void setTrackingDate(String trackingDate) {
        this.trackingDate = trackingDate;
    }

    public List<ScoreDTO> getScoreDTOList() {
        return scoreDTOList;
    }

    public void setScoreDTOList(List<ScoreDTO> scoreDTOList) {
        this.scoreDTOList = scoreDTOList;
    }

    public int getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(int trackingId) {
        this.trackingId = trackingId;
    }

    public double getAveragePoint() {
        return averagePoint;
    }

    public void setAveragePoint(double averagePoint) {
        this.averagePoint = averagePoint;
    }
}
