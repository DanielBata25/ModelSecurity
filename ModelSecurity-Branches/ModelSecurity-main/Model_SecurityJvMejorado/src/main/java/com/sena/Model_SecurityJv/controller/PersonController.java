package com.sena.Model_SecurityJv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sena.Model_SecurityJv.model.Person;
import com.sena.Model_SecurityJv.service.PersonService;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/")
    public ResponseEntity<Object> findAllPersons() {
        var listPersons = personService.findAllPersons();
        return new ResponseEntity<>(listPersons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdPerson(@PathVariable int id) {
        var person = personService.findByIdPerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/")
    public String save(@RequestBody Person person) {
        personService.save(person);
        return "Registrar OK";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Person person) {
        personService.update(id, person);
        return "Update OK";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        personService.delete(id);
        return "DELETE OK";
    }
}
