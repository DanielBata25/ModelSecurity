package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IFormModule;
import com.sena.Model_SecurityJv.model.FormModule;

@Service
public class FormModuleService {

    @Autowired
    private IFormModule formModuleData;

    public List<FormModule> findAll() {
        return formModuleData.findAll();
    }

    public Optional<FormModule> findById(int id) {
        return formModuleData.findById(id);
    }

    public void save(FormModule entity) {
        formModuleData.save(entity);
    }

    public void update(int id, FormModule entityUpdate) {
        var opt = findById(id);
        if (opt.isPresent()) {
            FormModule entity = opt.get();
            entity.setModuleId(entityUpdate.getModuleId());
            entity.setFormId(entityUpdate.getFormId());
            entity.setDeleted(entityUpdate.isDeleted());
            formModuleData.save(entity);
        }
    }

    public void delete(int id) {
        var opt = findById(id);
        if (opt.isPresent()) {
            formModuleData.delete(opt.get());
        }
    }
}

