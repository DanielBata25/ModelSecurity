package com.sena.Model_SecurityJv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.Model_SecurityJv.model.RolUser;
import com.sena.Model_SecurityJv.service.RolUserService;

@RestController
@RequestMapping("api/v1/roluser")
public class RolUserController {

    @Autowired
    private RolUserService rolUserService;

    @GetMapping("/")
    public ResponseEntity<Object> findAllRolUsers() {
        var listRolUsers = rolUserService.findAllRolUsers();
        return new ResponseEntity<>(listRolUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdRolUser(@PathVariable int id) {
        var rolUser = rolUserService.findByIdRolUser(id);
        return new ResponseEntity<>(rolUser, HttpStatus.OK);
    }

    @PostMapping("/")
    public String save(@RequestBody RolUser rolUser) {
        rolUserService.save(rolUser);
        return "Registrar OK";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody RolUser rolUser) {
        rolUserService.update(id, rolUser);
        return "Update OK";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        rolUserService.delete(id);
        return "DELETE OK";
    }
}

