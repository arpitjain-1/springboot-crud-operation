package com.CRUD.myproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.CRUD.myproject.model.User;

@Service
public class UserService {

    private List<User> userList = new ArrayList<>();

    UserService(){
        User user = new User(0, "Arpit", "a@a.com");
        userList.add(user);
    }

    public List<User> getAllUser(){
        return userList;
    }

    public User createUser(User user){
        int index = user.getId();
        while (userList.size() <= index) {
            userList.add(null);
        }

        userList.set(index, user);
        return user;
    }


    public User getCurrentUser(int id){
        User u = userList.get(id);
        return u;
    }

    public User updateCurrentUser(int id, User user){
        userList.set(id, user);
        return user;
    }

    public boolean deleteCurrentUser(int id){
        userList.remove(id);
        return true;
    }
}
