package com.sena.Model_SecurityJv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.Model_SecurityJv.model.User;
import com.sena.Model_SecurityJv.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<Object> findAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdUser(@PathVariable int id) {
        var user = userService.findByIdUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/")
    public String save(@RequestBody User user) {
        userService.save(user);
        return "Registrar OK";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody User user) {
        userService.update(id, user);
        return "Update OK";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        userService.delete(id);
        return "DELETE OK";
    }
}
