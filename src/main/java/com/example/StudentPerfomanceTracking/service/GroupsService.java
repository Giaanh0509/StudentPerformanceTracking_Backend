package com.example.StudentPerfomanceTracking.service;

import com.example.StudentPerfomanceTracking.dto.GroupDTO;
import com.example.StudentPerfomanceTracking.entity.Group;

import java.util.List;

public interface GroupsService {
    Group saveGroup(GroupDTO groupDTO);

    List<GroupDTO> findGroupByUserId(int userId);

    void deleteGroupById(int groupId);

    Group updateGroup(int groupId, GroupDTO groupDTO);

    List<GroupDTO> getAllGroups();

    GroupDTO getGroupById(int groupId);
}
