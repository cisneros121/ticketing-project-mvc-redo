package com.cydeo.service;

import com.cydeo.dto.ProjectDto;
import com.cydeo.dto.UserDto;

import java.util.List;

public interface ProjectService extends CrudService<ProjectDto,String> {

    void complete(ProjectDto projectDto);

    List<ProjectDto> getCountedListOfProjectDto(UserDto manager);





}
