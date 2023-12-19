package com.cydeo.service;

import com.cydeo.dto.ProjectDto;

public interface ProjectService extends CrudService<ProjectDto,String> {

    void complete(ProjectDto projectDto);





}
