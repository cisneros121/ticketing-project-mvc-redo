package com.cydeo.controller;

import com.cydeo.dto.ProjectDto;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(("/project"))
public class ProjectController {

    ProjectService projectService;
    UserService userService;
    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }




    @GetMapping("/create")
public String projectCreate(Model model){

    model.addAttribute("projectForm",new ProjectDto());
    model.addAttribute("projects",projectService.findAll());
    model.addAttribute("managers",userService.findAll());



    return "/project/create";
}


}