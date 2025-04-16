package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IForm;
import com.sena.Model_SecurityJv.model.Form;

@Service
public class FormService {

    @Autowired
    private IForm formData;

    public List<Form> findAll() {
        return formData.findAll();
    }

    public Optional<Form> findById(int id) {
        return formData.findById(id);
    }

    public void save(Form entity) {
        formData.save(entity);
    }

    public void update(int id, Form entityUpdate) {
        var opt = findById(id);
        if (opt.isPresent()) {
            Form entity = opt.get();
            entity.setName(entityUpdate.getName());
            entity.setDescription(entityUpdate.getDescription());
            entity.setDeleted(entityUpdate.isDeleted());
            formData.save(entity);
        }
    }

    public void delete(int id) {
        var opt = findById(id);
        if (opt.isPresent()) {
            formData.delete(opt.get());
        }
    }
}

