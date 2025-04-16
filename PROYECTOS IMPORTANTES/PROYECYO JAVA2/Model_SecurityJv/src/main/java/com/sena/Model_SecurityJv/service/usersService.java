package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IUsers;
import com.sena.Model_SecurityJv.model.users;

@Service
public class usersService {

    @Autowired
    private IUsers usersData;

    public List<users> findAllUsers() {
        return usersData.findAll();
    }

    public Optional<users> findByIdUsers(int id) {
        return usersData.findById(id);
    }

    public void save(users user) {
        usersData.save(user);
    }

    public void update(int id, users userUpdate) {
        var user = findByIdUsers(id);
        if (user.isPresent()) {
            user.get().setUserName(userUpdate.getUserName());
            user.get().setActive(userUpdate.isActive());
            user.get().setPassword(userUpdate.getPassword());
            user.get().setDeleted(userUpdate.isDeleted());
            user.get().setPersonId(userUpdate.getPersonId());
            usersData.save(user.get());
        }
    }

    public void delete(int id) {
        var user = findByIdUsers(id);
        if (user.isPresent()) {
            usersData.delete(user.get());
        }
    }
}
