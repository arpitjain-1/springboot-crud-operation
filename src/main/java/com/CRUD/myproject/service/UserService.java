// service/UserService.java
package com.CRUD.myproject.service;

import com.CRUD.myproject.model.User;
import com.CRUD.myproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> getAllUser() {
        return repo.findAll();
    }

    public User createUser(User user) {
        return repo.save(user);
    }

    public User getCurrentUser(int id) {
        return repo.findById((long) id).orElse(null);
    }

    public User updateCurrentUser(int id, User user) {
        if (repo.existsById((long) id)) {
            user.setId(id); // ensure the ID is set for update
            return repo.save(user);
        }
        return null;
    }

    public boolean deleteCurrentUser(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
