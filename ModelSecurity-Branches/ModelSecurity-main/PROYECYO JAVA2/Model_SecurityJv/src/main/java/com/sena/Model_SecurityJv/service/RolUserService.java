package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IRolUser;
import com.sena.Model_SecurityJv.model.RolUser;

@Service
public class RolUserService {

    @Autowired
    private IRolUser rolUserData;

    public List<RolUser> findAllRolUsers() {
        return rolUserData.findAll();
    }

    public Optional<RolUser> findByIdRolUser(int id) {
        return rolUserData.findById(id);
    }

    public void save(RolUser rolUser) {
        rolUserData.save(rolUser);
    }

    public void update(int id, RolUser rolUserUpdate) {
        var rolUserOpt = findByIdRolUser(id);
        if (rolUserOpt.isPresent()) {
            RolUser rolUser = rolUserOpt.get();
            rolUser.setRolId(rolUserUpdate.getRolId());
            rolUser.setUserId(rolUserUpdate.getUserId());
            rolUser.setDeleted(rolUserUpdate.isDeleted());
            rolUserData.save(rolUser);
        }
    }

    public void delete(int id) {
        var rolUserOpt = findByIdRolUser(id);
        if (rolUserOpt.isPresent()) {
            rolUserData.delete(rolUserOpt.get());
        }
    }
}
