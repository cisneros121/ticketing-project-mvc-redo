package com.cydeo.service;

import com.cydeo.dto.TaskDto;
import com.cydeo.service.impl.AbstractMapService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public interface TaskService extends CrudService<TaskDto,Long> {


}
