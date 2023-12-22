package com.cydeo.controller;

import com.cydeo.dto.TaskDto;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import com.cydeo.service.UserService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/task")
public class TaskController {

    TaskService taskService;
    ProjectService projectService;
    UserService userService;


    public TaskController(TaskService taskService, ProjectService projectService, UserService userService) {
        this.taskService = taskService;
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String createTask(Model model){

        model.addAttribute("taskForm",new TaskDto());
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("employees",userService.findEmployees());// create a method to bring all employees only
        model.addAttribute("taskList",taskService.findAll());


        return "task/create";
    }

    @PostMapping("/create")
    public String insert(TaskDto taskDto){

        taskService.save(taskDto);
        return "redirect:/task/create";
    }

    @GetMapping("/delete/{taskId}")
    public String delete(@PathVariable("taskId") Long taskId){

        taskService.deleteById(taskId);

        return "redirect:/task/create";
    }


    @GetMapping("/update/{taskId}")
    public String update(@PathVariable("taskId") Long taskId, Model model){



        model.addAttribute("task",taskService.findById(taskId));
        model.addAttribute("projects",projectService.findAll());
        model.addAttribute("employees",userService.findEmployees());// create a method to bring all employees only
        model.addAttribute("taskList",taskService.findAll());




        return "/task/update";
    }

    @PostMapping("/update/{taskId}")
    public String updatePost(@PathVariable("taskId") long taskId, TaskDto taskDto){
taskDto.setId(taskId);
        taskService.update(taskDto);




        return "redirect:/task/create";
    }

}
