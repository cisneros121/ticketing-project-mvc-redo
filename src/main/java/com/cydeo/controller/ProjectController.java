package com.cydeo.controller;

import com.cydeo.dto.ProjectDto;
import com.cydeo.dto.UserDto;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    model.addAttribute("project",new ProjectDto());
    model.addAttribute("projects",projectService.findAll());
    model.addAttribute("managers",userService.findManagers());



    return "/project/create";
}
    @PostMapping("/create")
    public String projectSave(@ModelAttribute("project") ProjectDto projectDto){


        projectService.save(projectDto);

        return "redirect:/project/create";
    }

    @GetMapping("/delete/{projectCode}")
    public String deleteProject(@PathVariable("projectCode") String projectCode){


        projectService.deleteById(projectCode);



return "redirect:/project/create";
    }

    @GetMapping("/complete/{projectcode}")
    public String completeProject(@PathVariable("projectcode") String project){

projectService.complete(projectService.findById(project));

return "redirect:/project/create";
    }

 @GetMapping("/update/{projectCode}")
    public String editProject(@PathVariable("projectCode") String project,Model model){
     model.addAttribute("project",projectService.findById(project));
     model.addAttribute("projects",projectService.findAll());
     model.addAttribute("managers",userService.findManagers());
        return "/project/update";
 }




    @PostMapping("/update")
    public String editProject(ProjectDto projectDto){


        projectService.update(projectDto);
        return "redirect:/project/create";
    }

    @GetMapping("/manager/project-status")
    public String updateProject(Model model){

        UserDto manager= userService.findById("JTor");

        List<ProjectDto> projects= projectService.getCountedListOfProjectDto(manager);

        model.addAttribute("projects",projects);

        return "/manager/project-status";
    }

}
