package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDto;
import com.cydeo.dto.TaskDto;
import com.cydeo.dto.UserDto;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<String,ProjectDto> implements ProjectService {

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    TaskService taskService;




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

        ProjectDto newProject= findById(object.getProjectCode());

        if (object.getProjectStatus()==null){
            object.setProjectStatus(newProject.getProjectStatus());
        }

        super.update(object.getProjectCode(), object);
    }

    @Override
    public void complete(ProjectDto projectDto) {
        projectDto.setProjectStatus(Status.COMPLETE);
        super.save(projectDto.getProjectCode(),projectDto);
    }

    @Override
    public List<ProjectDto> getCountedListOfProjectDto(UserDto manager) {
        List<ProjectDto> list= findAll().stream().filter(x->x.getManager().equals(manager)).map(x->{
            List<TaskDto> tasks=taskService.findAllManagerTasks(manager);
            int completeTasks= (int) tasks.stream().filter(t->t.getProject().equals(x) && t.getTaskStatus()==Status.COMPLETE).count();
            int incompleteTasks=(int) tasks.stream().filter(t->t.getProject().equals(x) && t.getTaskStatus()!=Status.COMPLETE).count();
            x.setCompleteTaskCounts(completeTasks);
            x.setUnfinishedTaskCounts(incompleteTasks);
            return x;
        }).collect(Collectors.toList());
        return list;
    }
}
