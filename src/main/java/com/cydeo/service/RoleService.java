package com.cydeo.service;

import com.cydeo.dto.RoleDto;
import com.cydeo.dto.UserDto;
import com.cydeo.entity.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RoleService extends CrudService <RoleDto,Long> {
    //save, findById,Delete,findAll

    RoleDto save (RoleDto role);

   RoleDto findById(Long id);

   List<RoleDto> findAll();


    void deleteById(Long id);
}
