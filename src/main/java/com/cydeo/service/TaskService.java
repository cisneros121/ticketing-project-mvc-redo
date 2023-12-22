package com.cydeo.service;

import com.cydeo.dto.TaskDto;
import com.cydeo.dto.UserDto;
import com.cydeo.service.impl.AbstractMapService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService extends CrudService<TaskDto,Long> {

    List<TaskDto> findAllManagerTasks(UserDto manager);

}
