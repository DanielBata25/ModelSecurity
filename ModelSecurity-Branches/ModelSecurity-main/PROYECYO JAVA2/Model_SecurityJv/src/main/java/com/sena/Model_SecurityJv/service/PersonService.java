package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IPerson;
import com.sena.Model_SecurityJv.model.Person;

@Service
public class PersonService {

    @Autowired
    private IPerson personData;

    public List<Person> findAllPersons() {
        return personData.findAll();
    }

    public Optional<Person> findByIdPerson(int id) {
        return personData.findById(id);
    }

    public void save(Person person) {
        personData.save(person);
    }

    public void update(int id, Person personUpdate) {
        var personOpt = findByIdPerson(id);
        if (personOpt.isPresent()) {
            Person person = personOpt.get();
            person.setFirstName(personUpdate.getFirstName());
            person.setLastName(personUpdate.getLastName());
            person.setEmail(personUpdate.getEmail());
            person.setPhoneNumber(personUpdate.getPhoneNumber());
            person.setAddress(personUpdate.getAddress());
            person.setDeleted(personUpdate.isDeleted());
            person.setUserId(personUpdate.getUserId());
            personData.save(person);
        }
    }

    public void delete(int id) {
        var personOpt = findByIdPerson(id);
        if (personOpt.isPresent()) {
            personData.delete(personOpt.get());
        }
    }
}
