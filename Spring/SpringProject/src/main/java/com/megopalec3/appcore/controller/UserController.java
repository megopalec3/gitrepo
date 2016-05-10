package com.megopalec3.appcore.controller;

import com.megopalec3.appcore.entity.User;
import com.megopalec3.appcore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value="/user/{id}")
    public String getUserById(Model model, @PathVariable long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "home";
    }

    @RequestMapping(value = "/new/user", method = RequestMethod.POST)
    public String saveNewUser(@ModelAttribute("user") User user, Model model) {
        userService.addUser(user);
        return "home";
    }
}
