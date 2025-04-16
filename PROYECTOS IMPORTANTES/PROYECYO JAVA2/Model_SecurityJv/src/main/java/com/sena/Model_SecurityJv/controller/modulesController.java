package com.sena.Model_SecurityJv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.Model_SecurityJv.model.modules;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("api/v1/modules")
public class modulesController {

    @Autowired
    private com.sena.Model_SecurityJv.service.modulesServices modulesServices;

    @GetMapping("/")
    public ResponseEntity<Object> findAllModules() {
        var listModules = modulesServices.findAllModules();
        return new ResponseEntity<>(listModules, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdModules(@PathVariable int id) {
        var module = modulesServices.findByIdModules(id);
        return new ResponseEntity<>(module, HttpStatus.OK);
    }

    @PostMapping("/")
    public String save(@RequestBody modules module) {
        modulesServices.save(module);
        return "Registrar OK";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody modules module) {
        modulesServices.update(id, module);
        return "Update OK";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        modulesServices.delete(id);
        return "DELETE OK";
    }
}
