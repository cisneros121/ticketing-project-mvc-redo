package com.cydeo.service.impl;

import com.cydeo.dto.UserDto;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl extends AbstractMapService<String,UserDto> implements UserService {
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


}
