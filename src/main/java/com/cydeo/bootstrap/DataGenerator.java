package com.cydeo.bootstrap;

import com.cydeo.dto.RoleDto;
import com.cydeo.dto.UserDto;
import com.cydeo.enums.Gender;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import com.cydeo.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {


RoleService roleService;
UserService userService;



    public DataGenerator(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        // will execute everything in this block first when application runs

        RoleDto adminRole= new RoleDto(1L,"Admin");
        RoleDto managerRole= new RoleDto(1L,"manager");
        RoleDto employeeRole= new RoleDto(1L,"Employee");

        //add data to map which will act as my database for now
roleService.save(adminRole);
roleService.save(managerRole);
roleService.save(employeeRole);


        UserDto userDto= new UserDto("Cameron","Cisneros","CCisn","123456789",true,"8328455744",managerRole, Gender.MALE);
        UserDto userDto2= new UserDto("James","Williams","JWill","123456789",true,"8328455744",managerRole, Gender.MALE);
        UserDto userDto3= new UserDto("Emily","Beck","EmBeck","123456789",true,"8328455744",managerRole, Gender.MALE);
        UserDto userDto4= new UserDto("Jasmine","Torres","JTor","123456789",true,"8328455744",managerRole, Gender.MALE);


userService.save(userDto);
userService.save(userDto2);
userService.save(userDto3);
userService.save(userDto4);


    }
}
