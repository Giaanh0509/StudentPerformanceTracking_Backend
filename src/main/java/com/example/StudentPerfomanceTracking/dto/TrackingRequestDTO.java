package com.example.StudentPerfomanceTracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TrackingRequestDTO {
    private int id;

    private String trackingDate;

    private int indicatorId;

    private int trackingId;

    @JsonProperty("studentTracking")
    private List<TrackingDetailsDTO> TrackingDetailsDTO;

    public TrackingRequestDTO(int id, String trackingDate, int indicatorId, int trackingId, List<TrackingDetailsDTO> TrackingDetailsDTO) {
        this.id = id;
        this.trackingDate = trackingDate;
        this.indicatorId = indicatorId;
        this.trackingId = trackingId;
        this.TrackingDetailsDTO = TrackingDetailsDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrackingDate() {
        return trackingDate;
    }

    public void setTrackingDate(String trackingDate) {
        this.trackingDate = trackingDate;
    }

    public int getIndicatorId() {
        return indicatorId;
    }

    public void setIndicatorId(int indicatorId) {
        this.indicatorId = indicatorId;
    }

    public int getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(int trackingId) {
        this.trackingId = trackingId;
    }

    public List<TrackingDetailsDTO> getTrackingDTOList() {
        return TrackingDetailsDTO;
    }

    public void setTrackingDTOList(List<TrackingDetailsDTO> trackingDTOList) {
        this.TrackingDetailsDTO = trackingDTOList;
    }
}
