package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IPermissions;
import com.sena.Model_SecurityJv.model.permissions;

@Service
public class permissionsService {

    @Autowired
    private IPermissions permissionsData;

    public List<permissions> findAllPermissions() {
        return permissionsData.findAll();
    }

    public Optional<permissions> findByIdPermissions(int id) {
        return permissionsData.findById(id);
    }

    public void save(permissions permission) {
        permissionsData.save(permission);
    }

    public void update(int id, permissions permissionUpdate) {
        var permission = findByIdPermissions(id);
        if (permission.isPresent()) {
            permission.get().setName(permissionUpdate.getName());
            permission.get().setDescription(permissionUpdate.getDescription());
            permission.get().setDeleted(permissionUpdate.isDeleted());
            permissionsData.save(permission.get());
        }
    }

    public void delete(int id) {
        var permission = findByIdPermissions(id);
        permission.ifPresent(value -> permissionsData.delete(value));
    }
}
