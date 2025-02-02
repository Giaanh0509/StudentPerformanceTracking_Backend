package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.IndicatorsRepository;
import com.example.StudentPerfomanceTracking.dao.SkillsRepository;
import com.example.StudentPerfomanceTracking.dto.IndicatorDTO;
import com.example.StudentPerfomanceTracking.entity.Indicator;
import com.example.StudentPerfomanceTracking.entity.Skill;
import com.example.StudentPerfomanceTracking.service.IndicatorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class IndicatorsServiceImpl implements IndicatorsService {

    @Autowired
    IndicatorsRepository indicatorsRepository;

    @Autowired
    SkillsRepository skillsRepository;

    @Override
    public Indicator saveIndicator(IndicatorDTO indicatorDTO) {
        Skill skill = skillsRepository.findSkillById(indicatorDTO.getSkillId());
        Indicator indicator = new Indicator(indicatorDTO.getName(), skill, indicatorDTO.getEvaluationType(), indicatorDTO.getScaleMin(), indicatorDTO.getScaleMax());
        indicatorsRepository.save(indicator);
        return null;
    }

    @Override
    public IndicatorDTO findBySkillId(int id) {
        Indicator indicator =  indicatorsRepository.findBySkillId(id);
        IndicatorDTO indicatorDTO = new IndicatorDTO(indicator.getId(),
                indicator.getName(),
                indicator.getScaleMin(),
                indicator.getScaleMax(),
                indicator.getEvaluationType(),
                indicator.getSkill().getId(),
                indicator.getSkill().getName());

        return indicatorDTO;
    }

    @Override
    public List<IndicatorDTO> findAll() {
        List<Indicator> indicators = indicatorsRepository.findAll();
        List<IndicatorDTO> indicatorDTOList = new ArrayList<>();
        for (Indicator indicator : indicators) {
            IndicatorDTO indicatorDTO = new IndicatorDTO(
                    indicator.getId(),
                    indicator.getName(),
                    indicator.getScaleMin(),
                    indicator.getScaleMax(),
                    indicator.getEvaluationType(),
                    indicator.getSkill().getId());

            indicatorDTOList.add(indicatorDTO);
        }

        return indicatorDTOList;
    }
}
