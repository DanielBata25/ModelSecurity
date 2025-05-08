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
    public ResponseEntity<Object> findAll() {
        var list = rolService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable int id) {
        var rol = rolService.findById(id);
        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody Rol rol) {
        rolService.save(rol);
        return new ResponseEntity<>("Registro OK", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable int id, @RequestBody Rol rol) {
        rolService.update(id, rol);
        return new ResponseEntity<>("Actualización OK", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        rolService.delete(id);
        return new ResponseEntity<>("Eliminado OK", HttpStatus.OK);
    }
}
