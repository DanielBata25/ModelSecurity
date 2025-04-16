package com.sena.Model_SecurityJv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.Model_SecurityJv.model.Permission;
import com.sena.Model_SecurityJv.service.PermissionService;

@RestController
@RequestMapping("api/v1/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/")
    public ResponseEntity<Object> findAllPermissions() {
        var listPermissions = permissionService.findAllPermissions();
        return new ResponseEntity<>(listPermissions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdPermission(@PathVariable int id) {
        var permission = permissionService.findByIdPermission(id);
        return new ResponseEntity<>(permission, HttpStatus.OK);
    }

    @PostMapping("/")
    public String save(@RequestBody Permission permission) {
        permissionService.save(permission);
        return "Registrar OK";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Permission permission) {
        permissionService.update(id, permission);
        return "Update OK";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        permissionService.delete(id);
        return "DELETE OK";
    }
}
