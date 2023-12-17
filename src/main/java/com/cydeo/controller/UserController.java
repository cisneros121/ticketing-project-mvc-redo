package com.cydeo.controller;

import com.cydeo.dto.UserDto;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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



    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String userName, Model model){

        //userService.update();

        model.addAttribute("user",userService.findById(userName));
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("userList",userService.findAll());
        return "/user/update";
    }

    @PostMapping("/update/{username}")
    public String updateUser(@PathVariable("username") String userName,UserDto userDto){

userService.update(userDto);

return "redirect:/user/create";
    }


}
