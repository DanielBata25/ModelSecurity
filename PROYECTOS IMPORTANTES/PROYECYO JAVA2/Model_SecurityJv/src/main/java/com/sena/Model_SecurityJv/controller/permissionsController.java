package com.sena.Model_SecurityJv.controller;

import com.sena.Model_SecurityJv.model.permissions;
import com.sena.Model_SecurityJv.service.permissionsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/permissions")
public class permissionsController {

    @Autowired
    private permissionsService permissionsService;

    @GetMapping("/")
    public ResponseEntity<Object> findAllPermissions() {
        var list = permissionsService.findAllPermissions();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdPermissions(@PathVariable int id) {
        var permission = permissionsService.findByIdPermissions(id);
        return new ResponseEntity<>(permission, HttpStatus.OK);
    }

    @PostMapping("/")
    public String save(@RequestBody permissions permission) {
        permissionsService.save(permission);
        return "Register OK";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody permissions permission) {
        permissionsService.update(id, permission);
        return "Update OK";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        permissionsService.delete(id);
        return "Delete OK";
    }
}
