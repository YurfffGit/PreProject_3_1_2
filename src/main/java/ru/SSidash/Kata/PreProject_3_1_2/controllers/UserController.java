package ru.SSidash.Kata.PreProject_3_1_2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.SSidash.Kata.PreProject_3_1_2.service.UserServiceImpl;


@Controller
public class UserController {
    public final UserServiceImpl userServiceImpl;


    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping ("/index")
    public String loginPage () {
        return "/index";
    }

    @GetMapping("/user")
    public String findUser (Model model) {
        model.addAttribute("user" , userServiceImpl.loadUserByUsername(userServiceImpl.getCurrentUsername()));
        return "show";
    }
}
