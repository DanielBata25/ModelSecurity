package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IRoles;
import com.sena.Model_SecurityJv.model.roles;

@Service
public class rolesService {

    @Autowired
    private IRoles rolesData;

    public List<roles> findAllRoles() {
        return rolesData.findAll();
    }

    public Optional<roles> findByIdRoles(int id) {
        return rolesData.findById(id);
    }

    public void save(roles rol) {
        rolesData.save(rol);
    }

    public void update(int id, roles rolUpdate) {
        var rol = findByIdRoles(id);
        if (rol.isPresent()) {
            rol.get().setName(rolUpdate.getName());
            rol.get().setCode(rolUpdate.getCode());
            rol.get().setDeleted(rolUpdate.isDeleted());
            rolesData.save(rol.get());
        }
    }

    public void delete(int id) {
        var rol = findByIdRoles(id);
        rol.ifPresent(value -> rolesData.delete(value));
    }
}
