package com.example.StudentPerfomanceTracking.service.impl;

import com.example.StudentPerfomanceTracking.dao.GroupsRepository;
import com.example.StudentPerfomanceTracking.dao.UsersRepository;
import com.example.StudentPerfomanceTracking.dto.GroupDTO;
import com.example.StudentPerfomanceTracking.entity.Group;
import com.example.StudentPerfomanceTracking.entity.User;
import com.example.StudentPerfomanceTracking.service.GroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GroupsServiceImpl implements GroupsService {

    @Autowired
    GroupsRepository groupsRepository;

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Group saveGroup(GroupDTO groupDTO) {
        User user = usersRepository.findById(groupDTO.getUserId());
        Group group = new Group(groupDTO.getName(), groupDTO.getDescription(), groupDTO.getCreateDate(), user);
        groupsRepository.save(group);
        return group;
    }

    @Override
    public List<GroupDTO> findGroupByUserId(int userId) {
        List<Group> groupList = groupsRepository.findSubjectByUserId(userId);
        List<GroupDTO> groupDTOList = new ArrayList<>();
        for (Group group : groupList) {
            GroupDTO groupDTO = new GroupDTO(
                    group.getId(),
                    group.getName(),
                    group.getDescription(),
                    group.getCreateDate(),
                    group.getUser().getId()
            );

            groupDTOList.add(groupDTO);
        }
        return groupDTOList;
    }
}
