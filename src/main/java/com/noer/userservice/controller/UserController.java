package com.noer.userservice.controller;

import com.noer.userservice.domain.UserAccount;
import com.noer.userservice.exception.UserException;
import com.noer.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return userService.saveUser(userAccount);
    }
    @GetMapping(value = "/user/{id}")
    public Optional<UserAccount> getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @PutMapping(value = "/user/updateUser")
    public UserAccount updateUser( @RequestParam Long id,@RequestBody UserAccount user){
        UserAccount userAccount = userService.getUserById(id).orElseThrow(()-> new UserException("user not found"));
        userAccount.setFirstName(user.getFirstName());
        userAccount.setLastName(user.getLastName());
        userAccount.setAddress(user.getAddress());
        userAccount.setEmail(user.getEmail());
        return userService.saveUser(userAccount);
    }
    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<String> removeUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted");
    }

}
