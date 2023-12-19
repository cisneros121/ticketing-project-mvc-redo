package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDto;
import com.cydeo.dto.UserDto;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<String,UserDto> implements UserService {
    UserService userService;
    @Override
    public UserDto save(UserDto obj) {
        return super.save(obj.getUserName(),obj);
    }

    @Override
    public List<UserDto> findAll() {
        return super.findAll();
    }

    @Override
    public UserDto findById(String id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(String id) {

        super.deleteById(id);
    }

    @Override
    public void update(UserDto object) {

        super.update(object.getUserName(),object);
    }


    @Override
    public List<UserDto> findManagers() {

return super.findAll().stream().filter(x->x.getRole().getId()==2).collect(Collectors.toList());
    }
}
