package com.cydeo.convertor;

import com.cydeo.dto.RoleDto;
import com.cydeo.service.RoleService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDtoConvertor implements Converter<String, RoleDto> {

    RoleService roleService;

    public RoleDtoConvertor(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDto convert(String source) {


        return roleService.findById(Long.parseLong(source));
    }
}
