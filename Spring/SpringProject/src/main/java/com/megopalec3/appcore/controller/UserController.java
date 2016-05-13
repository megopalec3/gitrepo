package com.megopalec3.appcore.controller;

import com.megopalec3.appcore.entity.User;
import com.megopalec3.appcore.entity.UserClientView;
import com.megopalec3.appcore.exceptions.ImageUploadException;
import com.megopalec3.appcore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public String getUserById(Model model, @PathVariable long id) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        if (user != null) {
            String avatarPath = userService.getAvatarPath(user);
            model.addAttribute("avapath", avatarPath);
        }
        return "home";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveNewUser(@ModelAttribute("user")
                              @Valid
                              UserClientView userClientView,
                              @RequestParam(value = "image", required = false)
                              MultipartFile image,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("user", userClientView);
            return "registration";
        }
        User createdUser = userService.addUser(userClientView);
        saveUserAvatar(image, createdUser);
        return "redirect:/user/" + createdUser.getId();
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationView(Model model) {
        model.addAttribute("user", new UserClientView());
        return "registration";
    }

    private void saveUserAvatar(MultipartFile image, User user) {
        if (!image.isEmpty()) {
            try {
                userService.saveUserAvatar(image, user);
            } catch (ImageUploadException e) {
                //TODO: Do something
            }
        }
    }
}
