package com.instagram.clone.controller;

import com.instagram.clone.entity.User;
import com.instagram.clone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(name="id") Long id){
        return userService.getUserById(id);
    }

    @PostMapping("users")
    public String saveUser(@Valid @RequestBody User user){
        userService.saveUser(user);
        return "Saved User Successfully";
    }
    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user , @PathVariable(name="id") Long id){
        User updatedUser = userService.getUserById(id);
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        userService.saveUser(updatedUser);
        return updatedUser;
    }

    @DeleteMapping("/users/{id}")
    public String deleteUserById(@PathVariable(name ="id") Long id){
        userService.deleteUserById(id);
        return "User Deleted Successfully";
    }



}
