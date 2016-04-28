package com.megopalec3.appcore.controller;

import com.megopalec3.appcore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String showHomePage(Map<String, Object> model) {
        model.put("user", userService.getUserById(1));
        return "home";
    }
}
