package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IModule;
import com.sena.Model_SecurityJv.model.Module;

@Service
public class ModuleService {

    @Autowired
    private IModule moduleData;

    public List<Module> findAll() {
        return moduleData.findAll();
    }

    public Optional<Module> findById(int id) {
        return moduleData.findById(id);
    }

    public void save(Module entity) {
        moduleData.save(entity);
    }

    public void update(int id, Module entityUpdate) {
        var opt = findById(id);
        if (opt.isPresent()) {
            Module entity = opt.get();
            entity.setName(entityUpdate.getName());
            entity.setDescription(entityUpdate.getDescription());
            entity.setDeleted(entityUpdate.isDeleted());
            moduleData.save(entity);
        }
    }

    public void delete(int id) {
        var opt = findById(id);
        if (opt.isPresent()) {
            moduleData.delete(opt.get());
        }
    }
}

