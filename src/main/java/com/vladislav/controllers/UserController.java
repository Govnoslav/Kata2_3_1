package com.vladislav.controllers;

import com.vladislav.entity.User;
import com.vladislav.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users",users);
        return "users";
    }

    @PostMapping("/new")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    };

    @GetMapping("/{id}")
    public String editUser(@PathVariable Long id,
                           Model model) {
        User user = userService.findUserById(id);
        model.addAttribute("user",user);
        return "usersEdit";
    }

    @PostMapping("/{id}")
    public String updateUser(User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }
}
