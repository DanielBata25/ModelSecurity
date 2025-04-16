package com.sena.Model_SecurityJv.controller;

import com.sena.Model_SecurityJv.model.roles;
import com.sena.Model_SecurityJv.service.rolesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/roles")
public class rolesController {

    @Autowired
    private rolesService rolesService;

    @GetMapping("/")
    public ResponseEntity<Object> findAllRoles() {
        var list = rolesService.findAllRoles();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdRoles(@PathVariable int id) {
        var rol = rolesService.findByIdRoles(id);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @PostMapping("/")
    public String save(@RequestBody roles rol) {
        rolesService.save(rol);
        return "Register OK";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody roles rol) {
        rolesService.update(id, rol);
        return "Update OK";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        rolesService.delete(id);
        return "Delete OK";
    }
}
