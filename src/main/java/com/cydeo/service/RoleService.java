package com.cydeo.service;

import com.cydeo.dto.RoleDto;
import com.cydeo.dto.UserDto;
import com.cydeo.entity.Role;

import java.util.List;

public interface RoleService extends CrudService <RoleDto,Long> {
    //save, findById,Delete,findAll

    RoleDto save (RoleDto role);

   RoleDto findById(Long id);

   List<RoleDto> findAll();

    void delete(RoleDto role);

    void deleteById(Long id);
}
