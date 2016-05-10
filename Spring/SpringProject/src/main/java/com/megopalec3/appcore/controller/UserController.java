package com.megopalec3.appcore.controller;

import com.megopalec3.appcore.entity.User;
import com.megopalec3.appcore.entity.mysql.MysqlUser;
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
    public String saveNewUser(@RequestParam(name = "userName") String name,
                              @RequestParam(name = "password") String password,
                              Model model) {
        //TODO: Refactor this
        User user = userService.addUser(new MysqlUser().setUserName(name).setPassword(password));
        model.addAttribute("user", user);
        return "home";
    }
}
