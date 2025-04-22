package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IPermission;
import com.sena.Model_SecurityJv.model.Permission;

@Service
public class PermissionService {

    @Autowired
    private IPermission permissionData;

    public List<Permission> findAllPermissions() {
        return permissionData.findAll();
    }

    public Optional<Permission> findByIdPermission(int id) {
        return permissionData.findById(id);
    }

    public void save(Permission permission) {
        permissionData.save(permission);
    }

    public void update(int id, Permission permissionUpdate) {
        var permissionOpt = findByIdPermission(id);
        if (permissionOpt.isPresent()) {
            Permission permission = permissionOpt.get();
            permission.setName(permissionUpdate.getName());
            permission.setDescription(permissionUpdate.getDescription());
            permission.setDeleted(permissionUpdate.isDeleted());
            permissionData.save(permission);
        }
    }

    public void delete(int id) {
        var permissionOpt = findByIdPermission(id);
        if (permissionOpt.isPresent()) {
            permissionData.delete(permissionOpt.get());
        }
    }
}
