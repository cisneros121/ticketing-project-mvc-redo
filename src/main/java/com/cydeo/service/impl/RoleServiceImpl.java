package com.cydeo.service.impl;

import com.cydeo.dto.RoleDto;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl extends AbstractMapService<Long,RoleDto> implements RoleService {


    @Override
    public RoleDto save(RoleDto role) {
        return super.save(role.getId(),role);
    }

    @Override
    public RoleDto findById(Long id) {
        return super.findById(id);
    }


    @Override
    public List<RoleDto> findAll() {
        return super.findAll();
    }


    @Override
    public void deleteById(Long id) {
super.deleteById(id);
    }

    @Override
    public void update(RoleDto object) {

        super.update(object.getId(),object);
    }
}
