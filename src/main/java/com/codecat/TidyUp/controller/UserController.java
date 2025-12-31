package com.codecat.TidyUp.controller;

import com.codecat.TidyUp.model.User;
import com.codecat.TidyUp.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService= userService;
    }

    @GetMapping("/{user_id}")
    public Optional<User> getUserInfo(@PathVariable Long user_id){
        return userService.getUserInfo(user_id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @DeleteMapping("/{user_id}")
    public void deleteUser (@PathVariable Long user_id){
        userService.deleteUser(user_id);
    }
}
