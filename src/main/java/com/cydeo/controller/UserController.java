package com.cydeo.controller;

import com.cydeo.dto.UserDto;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {


    RoleService roleService;
    UserService userService;

    public UserController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/create")
    public String userCreate(Model model){

        model.addAttribute("user",new UserDto());
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("userList",userService.findAll());


        return "/user/create";
    }

    @PostMapping("/create")
    public String insertUser (@ModelAttribute("user") UserDto userDto, Model model){

       // model.addAttribute("user",new UserDto());
      //  model.addAttribute("roles",roleService.findAll());
        userService.save(userDto);
       // model.addAttribute("userList",userService.findAll());
        return "redirect:/user/create";
    }
}
