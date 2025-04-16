package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IRol;
import com.sena.Model_SecurityJv.model.Rol;

@Service
public class RolService {

    @Autowired
    private IRol rolData;

    public List<Rol> findAllRols() { return rolData.findAll(); }
    public Optional<Rol> findByIdRol(int id) { return rolData.findById(id); }
    public void save(Rol rol) { rolData.save(rol); }

    public void update(int id, Rol rolUpdate) {
        var optRol = findByIdRol(id);
        if (optRol.isPresent()) {
            Rol r = optRol.get();
            r.setName(rolUpdate.getName());
            r.setCode(rolUpdate.getCode());
            r.setDeleted(rolUpdate.isDeleted());
            r.setCreateAt(rolUpdate.getCreateAt());
            r.setDeleteAt(rolUpdate.getDeleteAt());
            rolData.save(r);
        }
    }

    public void delete(int id) {
        var optRol = findByIdRol(id);
        optRol.ifPresent(rolData::delete);
    }
}
