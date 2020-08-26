package com.noer.userservice.controller;

import com.noer.userservice.domain.UserAccount;
import com.noer.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userservice")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public List<UserAccount> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping(value = "/createUser")
    public UserAccount createUser(@Valid @RequestBody UserAccount userAccount){
        return userService.CreateNewUser(userAccount);
    }
    @GetMapping(value = "/user/{id}")
    public Optional<UserAccount> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }



}
