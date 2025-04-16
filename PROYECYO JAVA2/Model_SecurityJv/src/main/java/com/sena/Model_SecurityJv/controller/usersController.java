package com.sena.Model_SecurityJv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.Model_SecurityJv.model.users;
import com.sena.Model_SecurityJv.service.usersService;

@RestController
@RequestMapping("api/v1/users")
public class usersController {

    @Autowired
    private usersService usersService;

    @GetMapping("/")
    public ResponseEntity<Object> findAllUsers() {
        var list = usersService.findAllUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdUsers(@PathVariable int id) {
        var user = usersService.findByIdUsers(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/")
    public String save(@RequestBody users user) {
        usersService.save(user);
        return "Register OK";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody users user) {
        usersService.update(id, user);
        return "Update OK";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        usersService.delete(id);
        return "Delete OK";
    }
}
