package com.CRUD.myproject.controller;

import com.CRUD.myproject.model.User;
import com.CRUD.myproject.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;


// Study about the POJO


@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> getAllUser() {
        return service.getAllUser();
    }

    @PostMapping("/new")
    public User newUser(@RequestBody User user) {    
        return service.createUser(user);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable int id){
        return service.getCurrentUser(id);
    }
    
    @PutMapping("/{id}")
    public User updateUserById(@PathVariable int id, @RequestBody User user){
        return service.updateCurrentUser(id, user);
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        boolean deleteResult =  service.deleteCurrentUser(id);
        return deleteResult ? "true" : "false";
    }
}
