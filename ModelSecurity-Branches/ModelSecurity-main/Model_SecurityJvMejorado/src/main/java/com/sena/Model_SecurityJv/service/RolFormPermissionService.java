package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.Model_SecurityJv.interfaces.IRolFormPermission;
import com.sena.Model_SecurityJv.model.RolFormPermission;

@Service
public class RolFormPermissionService {

    @Autowired
    private IRolFormPermission rolFormPermissionData;

    public List<RolFormPermission> findAll() {
        return rolFormPermissionData.findAll();
    }

    public Optional<RolFormPermission> findById(int id) {
        return rolFormPermissionData.findById(id);
    }

    public void save(RolFormPermission entity) {
        rolFormPermissionData.save(entity);
    }

    public void update(int id, RolFormPermission entityUpdate) {
        var opt = findById(id);
        if (opt.isPresent()) {
            RolFormPermission entity = opt.get();
            entity.setRolId(entityUpdate.getRolId());
            entity.setFormId(entityUpdate.getFormId());
            entity.setPermissionId(entityUpdate.getPermissionId());
            entity.setDeleted(entityUpdate.isDeleted());
            rolFormPermissionData.save(entity);
        }
    }

    public void delete(int id) {
        var opt = findById(id);
        if (opt.isPresent()) {
            rolFormPermissionData.delete(opt.get());
        }
    }
}
