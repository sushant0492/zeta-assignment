package com.zeta.assignment.api;


import com.zeta.assignment.model.User;
import com.zeta.assignment.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/v2")
public class UserController {

    UserService userService;

    @Autowired
    UserController(UserService userService){
    this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUserList(){
        return userService.findAll();
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User requestBody){
        return  userService.add(requestBody);
    }
}
