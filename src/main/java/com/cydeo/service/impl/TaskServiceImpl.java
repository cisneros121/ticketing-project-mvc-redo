package com.cydeo.service.impl;

import com.cydeo.dto.TaskDto;
import com.cydeo.dto.UserDto;
import com.cydeo.enums.Status;
import com.cydeo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<Long,TaskDto> implements TaskService {
    @Override
    public TaskDto save(TaskDto obj) {

        if (obj.getAssignedDate()==null){

            obj.setAssignedDate(LocalDate.now());
        }

        if (obj.getId()==null){
            obj.setId(UUID.randomUUID().getMostSignificantBits());
        }

        if (obj.getTaskStatus()==null){
            obj.setTaskStatus(Status.OPEN);
        }


        return super.save(obj.getId(),obj);
    }



    @Override
    public TaskDto findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(Long id) {


        super.deleteById(id);
    }

    @Override
    public void update(TaskDto object) {

        if (object.getAssignedDate()==null){

            object.setAssignedDate(LocalDate.now());
        }

        super.update(object.getId(),object);
    }

    @Override
    public List<TaskDto> findAll() {
        return super.findAll();
    }


    @Override
    public List<TaskDto> findAllManagerTasks(UserDto manager) {
        return findAll().stream().filter(x->x.getProject().getManager().equals(manager)).collect(Collectors.toList());
    }
}
