package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDto;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<String,ProjectDto> implements ProjectService {

    @Override
    public ProjectDto save(ProjectDto obj) {
        if (obj.getProjectStatus()==null){
            obj.setProjectStatus(Status.OPEN);
        }
        return super.save(obj.getProjectCode(), obj);
    }

    @Override
    public List<ProjectDto> findAll() {
        return super.findAll();
    }

    @Override
    public ProjectDto findById(String s) {
        return super.findById(s);
    }

    @Override
    public void deleteById(String s) {

        super.deleteById(s);
    }

    @Override
    public void update(ProjectDto object) {

        super.update(object.getProjectCode(), object);
    }

    @Override
    public void complete(ProjectDto projectDto) {
        projectDto.setProjectStatus(Status.COMPLETE);
        super.save(projectDto.getProjectCode(),projectDto);
    }
}
