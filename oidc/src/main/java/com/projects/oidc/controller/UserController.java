package com.projects.oidc.controller;

import com.projects.oidc.entity.User;
import com.projects.oidc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @PostMapping("/user/new")
    public User newUser(@ModelAttribute User user){
        return userService.saveUser(user);
    }

    @PutMapping("/user/update")
    public User updateUser(@ModelAttribute User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/delete/{userId}")
    public User deleteUser(@PathVariable String userId){
        return userService.deleteUser(userId);
    }
}
