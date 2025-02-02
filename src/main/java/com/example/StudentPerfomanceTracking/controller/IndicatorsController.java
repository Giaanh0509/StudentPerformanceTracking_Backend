package com.example.StudentPerfomanceTracking.controller;

import com.example.StudentPerfomanceTracking.dto.IndicatorDTO;
import com.example.StudentPerfomanceTracking.entity.Indicator;
import com.example.StudentPerfomanceTracking.service.IndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/indicators")
public class IndicatorsController {

    @Autowired
    IndicatorsService indicatorsService;

    @PostMapping("/new")
    Indicator createNewIndicator(@RequestBody IndicatorDTO indicatorDTO) {
        return indicatorsService.saveIndicator(indicatorDTO);
    }

    @GetMapping("/all")
    public List<IndicatorDTO> getIndicatorByAll() {
        return indicatorsService.findAll();
    }

    @GetMapping("/skillId={skillId}")
    public IndicatorDTO getIndicatorBySkillId(@PathVariable int skillId) {
        if(indicatorsService.findBySkillId(skillId) == null) return null;
        return indicatorsService.findBySkillId(skillId);
    }
}
