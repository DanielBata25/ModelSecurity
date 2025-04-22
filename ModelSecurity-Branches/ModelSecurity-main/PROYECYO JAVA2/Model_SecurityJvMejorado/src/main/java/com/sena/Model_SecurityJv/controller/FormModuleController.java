package com.sena.Model_SecurityJv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.Model_SecurityJv.model.FormModule;
import com.sena.Model_SecurityJv.service.FormModuleService;

@RestController
@RequestMapping("api/v1/form-module")
public class FormModuleController {

    @Autowired
    private FormModuleService service;

    @GetMapping("/")
    public ResponseEntity<Object> findAll() {
        var list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        var entity = service.findById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping("/")
    public String save(@RequestBody FormModule entity) {
        service.save(entity);
        return "Registrar OK";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody FormModule entity) {
        service.update(id, entity);
        return "Update OK";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "DELETE OK";
    }
}
