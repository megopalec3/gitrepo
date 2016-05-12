package com.megopalec3.appcore.controller;

import com.megopalec3.appcore.entity.User;
import com.megopalec3.appcore.entity.UserClientView;
import com.megopalec3.appcore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public String getUserById(Model model, @PathVariable long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "home";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveNewUser(UserClientView userClientView) {
        User createdUser = userService.addUser(userClientView);
        return "redirect:/user/" + createdUser.getId();
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationView(Model model) {
        model.addAttribute("user", new UserClientView());
        return "registration";
    }
}
