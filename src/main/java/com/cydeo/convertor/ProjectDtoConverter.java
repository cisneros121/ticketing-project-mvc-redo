package com.cydeo.convertor;

import com.cydeo.dto.ProjectDto;
import com.cydeo.dto.UserDto;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class ProjectDtoConverter implements Converter<String, UserDto> {
   UserService userService;

    public ProjectDtoConverter(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDto convert(String source) {
        return userService.findById(source);
    }
}
