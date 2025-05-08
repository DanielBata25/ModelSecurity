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

    public List<Rol> findAll() {
        return rolData.findAll();
    }

    public Optional<Rol> findById(int id) {
        return rolData.findById(id);
    }

    public void save(Rol rol) {
        rolData.save(rol);
    }

    public void update(int id, Rol rolUpdate) {
        Optional<Rol> opt = findById(id);
        if (opt.isPresent()) {
            Rol rol = opt.get();
            rol.setName(rolUpdate.getName());
            rol.setDescription(rolUpdate.getDescription());
            rol.setDeleted(rolUpdate.isDeleted());
            rol.setRolUser(rolUpdate.getRolUser()); // si quieres actualizar la relación
            rol.setRolFormPermission(rolUpdate.getRolFormPermission()); // opcional también
            rolData.save(rol);
        }
    }

    public void delete(int id) {
        findById(id).ifPresent(rolData::delete);
    }
}
