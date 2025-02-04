package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.*;
import com.example.StudentPerfomanceTracking.dto.ObjectiveDTO;
import com.example.StudentPerfomanceTracking.entity.*;
import com.example.StudentPerfomanceTracking.service.ObjectivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectivesServiceImpl implements ObjectivesService {

    @Autowired
    ObjectivesRepository objectivesRepository;

    @Autowired
    IndicatorsRepository indicatorsRepository;

    @Autowired
    ObjectivesDetailsRepository objectivesDetailsRepository;

    @Autowired
    StudentsObjectivesRepository studentsObjectivesRepository;

    @Autowired
    StudentsGroupsRepository studentsGroupsRepository;

    @Override
    public void saveObjective(int groupId, String objectiveName, List<ObjectiveDTO> objectiveDTOList) {
        Objective objective = new Objective(objectiveName);
//        objectivesRepository.save(objective);

        List<Student> studentIdList = studentsGroupsRepository.findStudentId(groupId);
        for(Student student: studentIdList) {
            StudentObjective studentObjective = new StudentObjective(student, objective);
//            studentsObjectivesRepository.save(studentObjective);
        }

        for(ObjectiveDTO objectiveDTO: objectiveDTOList) {
            Indicator indicator = indicatorsRepository.findById(objectiveDTO.getIndicatorId());
            ObjectiveDetail objectiveDetail = new ObjectiveDetail(objective, objectiveDTO.getStartDate(), objectiveDTO.getEndDate(), indicator, objectiveDTO.getStartValue(), objectiveDTO.getObjectiveValue());
//            objectivesDetailsRepository.save(objectiveDetail);
        }
    }
}
