package com.sena.Model_SecurityJv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.Model_SecurityJv.model.Rol;
import com.sena.Model_SecurityJv.service.RolService;

@RestController
@RequestMapping("api/v1/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/")
    public ResponseEntity<Object> findAllRols() {
        var list = rolService.findAllRols();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdRol(@PathVariable int id) {
        var rol = rolService.findByIdRol(id);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @PostMapping("/")
    public String save(@RequestBody Rol rol) {
        rolService.save(rol);
        return "Registrar OK";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Rol rol) {
        rolService.update(id, rol);
        return "Update OK";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        rolService.delete(id);
        return "DELETE OK";
    }
}
