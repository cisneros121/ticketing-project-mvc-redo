package com.cydeo.bootstrap;

import com.cydeo.dto.ProjectDto;
import com.cydeo.dto.RoleDto;
import com.cydeo.dto.UserDto;
import com.cydeo.enums.Gender;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import com.cydeo.service.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataGenerator implements CommandLineRunner {


RoleService roleService;
UserService userService;
ProjectService projectService;



    public DataGenerator(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        // will execute everything in this block first when application runs

        RoleDto adminRole= new RoleDto(1L,"Admin");
        RoleDto managerRole= new RoleDto(2L,"Manager");
        RoleDto employeeRole= new RoleDto(3L,"Employee");

        //add data to map which will act as my database for now
roleService.save(adminRole);
roleService.save(managerRole);
roleService.save(employeeRole);


        UserDto userDto= new UserDto("Cameron","Cisneros","CCisn","123456789",true,"8328455744",managerRole, Gender.MALE);
        UserDto userDto2= new UserDto("James","Williams","JWill","177653789",true,"832456744",adminRole, Gender.MALE);
        UserDto userDto3= new UserDto("Emily","Beck","EmBeck","123455769859",true,"8328477444",employeeRole, Gender.FEMALE);
        UserDto userDto4= new UserDto("Jasmine","Torres","JTor","123jhg59",true,"8328411444",managerRole, Gender.FEMALE);


userService.save(userDto);
userService.save(userDto2);
userService.save(userDto3);
userService.save(userDto4);


        ProjectDto projectDto= new ProjectDto("Spring MVC","PRO1",userDto4, LocalDate.now(),LocalDate.now().plusDays(30),"creating db", Status.OPEN);
        ProjectDto projectDto2= new ProjectDto("Spring ORM","ER12",userDto, LocalDate.now(),LocalDate.now().plusDays(12),"creating db", Status.OPEN);
        ProjectDto projectDto3= new ProjectDto("Spring CONTAINER","AB33",userDto, LocalDate.now(),LocalDate.now().plusDays(18),"creating db", Status.OPEN);

projectService.save(projectDto);
projectService.save(projectDto2);
projectService.save(projectDto3);


    }
}
