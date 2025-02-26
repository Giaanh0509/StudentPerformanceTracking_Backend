package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.*;
import com.example.StudentPerfomanceTracking.dto.IndicatorDTO;
import com.example.StudentPerfomanceTracking.dto.ObjectiveDTO;
import com.example.StudentPerfomanceTracking.dto.ObjectiveDetailDTO;
import com.example.StudentPerfomanceTracking.entity.*;
import com.example.StudentPerfomanceTracking.service.ObjectivesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
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

    @Autowired
    SubjectsRepository subjectsRepository;

    @Autowired
    GroupsRepository groupsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public void saveObjective(int groupId, String createDate, int subjectId, int userId, String objectiveName, List<ObjectiveDetailDTO> objectiveDetailDTOList) {
        Group group = groupsRepository.findGroupById(groupId);
        Subject subject = subjectsRepository.findSubjectById(subjectId);
        User user = usersRepository.findById(userId);
        Objective objective = new Objective(objectiveName, createDate, user, subject);
        objectivesRepository.save(objective);

        List<Student> studentIdList = studentsGroupsRepository.findStudentId(groupId);
        for(Student student: studentIdList) {
            StudentObjective studentObjective = new StudentObjective(student, objective, group);
            studentsObjectivesRepository.save(studentObjective);
        }

        for(ObjectiveDetailDTO objectiveDetailDTO : objectiveDetailDTOList) {
            Indicator indicator = indicatorsRepository.findById(objectiveDetailDTO.getIndicatorId());
            ObjectiveDetail objectiveDetail = new ObjectiveDetail(objective, objectiveDetailDTO.getStartDate(), objectiveDetailDTO.getEndDate(), indicator, objectiveDetailDTO.getStartValue(), objectiveDetailDTO.getObjectiveValue());
            objectivesDetailsRepository.save(objectiveDetail);
        }
    }

    @Override
    public List<ObjectiveDTO> findObjectivesByUserId(int userId) {
        List<Objective> objectiveList =  objectivesRepository.findObjectiveByUserId(userId);
        List<ObjectiveDTO> objectiveDTOList = new ArrayList<>();
        for(Objective objective: objectiveList) {
            Subject subject = subjectsRepository.findSubjectById(objective.getSubject().getId());
            Group group = studentsObjectivesRepository.findGroupByObjectiveId(objective.getId());
            ObjectiveDTO objectiveDTO = new ObjectiveDTO(objective.getId(), objective.getName(), subject.getName(), group.getName(), objective.getCreateDate());

            objectiveDTOList.add(objectiveDTO);
        }

        return objectiveDTOList;
    }

    @Override
    public void deleteObjective(int objectiveId) {
        if (!objectivesRepository.existsById(objectiveId)) {
            throw new RuntimeException("Objective với Id " + objectiveId + " không tồn tại.");
        }

        objectivesRepository.deleteObjectiveById(objectiveId);
    }

    @Override
    public ObjectiveDTO findObjectiveById(int objectiveId) {
        Objective objective = objectivesRepository.findObjectiveById(objectiveId);
        Group group = studentsObjectivesRepository.findGroupByObjectiveId(objectiveId);
        Subject subject = subjectsRepository.findSubjectById(objective.getSubject().getId());
        List<Indicator> indicators = objectivesDetailsRepository.findIndicatorsByObjectiveId(objectiveId);
        List<IndicatorDTO> indicatorDTOList = new ArrayList<>();

        for (Indicator indicator : indicators) {
            IndicatorDTO indicatorDTO = new IndicatorDTO(
                    indicator.getId(),
                    indicator.getName(),
                    indicator.getScaleMin(),
                    indicator.getScaleMax(),
                    indicator.getEvaluationType(),
                    indicator.getSkill().getId(),
                    indicator.getSkill().getName());
            indicatorDTOList.add(indicatorDTO);
        }
        ObjectiveDTO objectiveDTO = new ObjectiveDTO(objective.getId(), objective.getName(), subject.getName(), group.getName(), objective.getCreateDate(), indicatorDTOList);
        return objectiveDTO;
    }
}
