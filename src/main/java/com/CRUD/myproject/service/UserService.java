package com.CRUD.myproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.CRUD.myproject.model.User;

@Service
public class UserService {

    private List<User> userList = new ArrayList<>();
    
    public User sampUser() {
        // Sample user data
        User user = new User(1, "Arpit", "a@a.com");
        userList.add(user);
        return user;
    }

    public List<User> getAllUser(){
        return userList;
    }   
    
    public User createUser(User user){
        userList.add(user);
        return user;
    }

    public User getCurrentUser(int id){
        User u = userList.get(id);
        return u;
    }

    public User updateCurrentUser(int id, User user){
        User u = userList.set(id, user);
        return u;
    }

    public boolean deleteCurrentUser(int id){
        userList.remove(id);
        return true;
    }
}
