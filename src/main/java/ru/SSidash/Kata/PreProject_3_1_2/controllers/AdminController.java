package ru.SSidash.Kata.PreProject_3_1_2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.SSidash.Kata.PreProject_3_1_2.models.Role;
import ru.SSidash.Kata.PreProject_3_1_2.models.User;
import ru.SSidash.Kata.PreProject_3_1_2.service.RoleServiceImpl;
import ru.SSidash.Kata.PreProject_3_1_2.service.UserServiceImpl;


import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    public final UserServiceImpl userServiceImpl;
    private final RoleServiceImpl roleServiceImpl;

    @Autowired
    public AdminController(UserServiceImpl userServiceImpl, RoleServiceImpl roleServiceImpl) {
        this.userServiceImpl = userServiceImpl;
        this.roleServiceImpl = roleServiceImpl;
    }

    @GetMapping
    public String getAllUsers(Principal principal, Model model) {
        model.addAttribute("allUsers", userServiceImpl.listUser());
        model.addAttribute("admin", userServiceImpl.findByUsername(principal.getName()));
        model.addAttribute("roles", roleServiceImpl.getRoleList());
        return "/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userServiceImpl.removeUser(id);
        return "redirect:/admin";
    }

    @PostMapping("/update/{id}")
    public String update
            (@ModelAttribute("user") User user, @PathVariable("id") int id, @RequestParam(name = "roles", required = false) String[] roles) {
        List<Role> roles1 = new ArrayList<>();
        if (roles == null) {
            user.setRoles((List<Role>) userServiceImpl.getUserById(id).getRoles());
        } else {
            for (String role : roles) {
                roles1.add(roleServiceImpl.getRoleById(id));
                user.setRoles(roles1);
            }
        }
        userServiceImpl.updateUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") User user, @RequestParam("roles") List<String> role) {
        user.setRoles(userServiceImpl.getSetOfRoles(role));
        userServiceImpl.addUser(user);
        return "redirect:/admin";
    }
}
