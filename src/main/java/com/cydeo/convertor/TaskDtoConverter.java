package com.cydeo.convertor;

import com.cydeo.dto.ProjectDto;
import com.cydeo.service.ProjectService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class TaskDtoConverter implements Converter<String, ProjectDto> {

    ProjectService projectService;

    public TaskDtoConverter(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public ProjectDto convert(String source) {
        return projectService.findById(source);

    }
}
