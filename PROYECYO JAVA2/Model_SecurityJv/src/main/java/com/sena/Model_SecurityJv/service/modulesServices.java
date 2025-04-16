package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IModule;
import com.sena.Model_SecurityJv.model.modules;

@Service
public class modulesServices {

    @Autowired
    private IModule modulesData;

    public List<modules> findAllModules() {
        return modulesData.findAll();
    }

    public Optional<modules> findByIdModules(int id) {
        return modulesData.findById(id);
    }

    public void save(modules module) {
        modulesData.save(module);
    }

    public void update(int id, modules moduleUpdate) {
        var module = findByIdModules(id);
        if (module.isPresent()) {
            module.get().setName(moduleUpdate.getName());
            module.get().setDescription(moduleUpdate.getDescription());
            module.get().setDeleted(moduleUpdate.isDeleted());
            modulesData.save(module.get());
        }
    }

    public void delete(int id) {
        var module = findByIdModules(id);
        if (module.isPresent()) {
            modulesData.delete(module.get());
        }
    }
}
