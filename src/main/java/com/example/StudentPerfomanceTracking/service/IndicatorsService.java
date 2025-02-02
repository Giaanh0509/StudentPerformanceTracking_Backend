package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.IndicatorDTO;
import com.example.StudentPerfomanceTracking.entity.Indicator;

import java.util.List;

public interface IndicatorsService {
    Indicator saveIndicator(IndicatorDTO indicatorDTO);

    IndicatorDTO findBySkillId(int id);

    List<IndicatorDTO> findAll();
}
