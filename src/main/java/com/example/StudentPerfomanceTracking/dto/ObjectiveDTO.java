package com.example.StudentPerfomanceTracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ObjectiveDTO {
    private int id;

    private String name;

    private String subject;

    private String group;

    private int groupId;

    private String createDate;

    private List<IndicatorDTO> indicators;

    public ObjectiveDTO(String name) {
        this.name = name;
    }

    public ObjectiveDTO(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public ObjectiveDTO(String name, String subject, String group) {
        this.name = name;
        this.subject = subject;
        this.group = group;
    }

    public ObjectiveDTO(String name, String subject, String group, String createDate) {
        this.name = name;
        this.subject = subject;
        this.group = group;
        this.createDate = createDate;
    }

    public ObjectiveDTO(int id, String name, String subject, String group, String createDate) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.group = group;
        this.createDate = createDate;
    }

    public ObjectiveDTO(int id, String name, String subject, String group, String createDate, List<IndicatorDTO> indicators) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.group = group;
        this.createDate = createDate;
        this.indicators = indicators;
    }

    public ObjectiveDTO(int id, String name, String subject, String group, int groupId, String createDate, List<IndicatorDTO> indicators) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.group = group;
        this.groupId = groupId;
        this.createDate = createDate;
        this.indicators = indicators;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<IndicatorDTO> getIndicatorDTOList() {
        return indicators;
    }

    public void setIndicatorDTOList(List<IndicatorDTO> indicators) {
        this.indicators = indicators;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
