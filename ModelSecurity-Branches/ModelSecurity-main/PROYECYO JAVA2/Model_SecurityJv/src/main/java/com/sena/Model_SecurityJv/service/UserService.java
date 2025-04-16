package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IUser;
import com.sena.Model_SecurityJv.model.User;

@Service
public class UserService {

    @Autowired
    private IUser userData;

    public List<User> findAllUsers() {
        return User.findAll();
    }

    public Optional<User> findByIdUser(int id) {
        return User.findById(id);
    }

    public void save(User user) {
        userData.save(user);
    }

    public void update(int id, User userUpdate) {
        var optUser = findByIdUser(id);
        if (optUser.isPresent()) {
            User u = optUser.get();
            u.setUserName(userUpdate.getUserName());
            u.setActive(userUpdate.isActive());
            u.setPassword(userUpdate.getPassword());
            u.setDeleted(userUpdate.isDeleted());
            u.setPersonId(userUpdate.getPersonId());
            userData.save(u);
        }
    }

    public void delete(int id) {
        var optUser = findByIdUser(id);
        optUser.ifPresent(userData::delete);
    }
}
