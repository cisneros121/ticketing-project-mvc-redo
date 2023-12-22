package com.cydeo.convertor;

import com.cydeo.dto.TaskDto;
import com.cydeo.service.TaskService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class TaskDtoConverter2 implements Converter<String, TaskDto> {

    TaskService taskService;

    public TaskDtoConverter2(TaskService taskService) {
        this.taskService = taskService;
    }


    @Override
    public TaskDto convert(String source) {
        return taskService.findById(Long.valueOf(source));
    }
}
