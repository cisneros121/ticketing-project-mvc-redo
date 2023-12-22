package com.cydeo.service;

import com.cydeo.dto.UserDto;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserService  extends CrudService <UserDto,String> {


    List<UserDto> managers= new ArrayList<>();


    List<UserDto> findManagers ();

    List<UserDto> findEmployees();



}
