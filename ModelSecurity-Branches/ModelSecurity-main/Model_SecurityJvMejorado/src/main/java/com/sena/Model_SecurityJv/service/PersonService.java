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

    // Obtener todas las personas
    public List<Person> findAllPersons() {
        return personData.findAll();
    }

    // Buscar persona por ID
    public Optional<Person> findByIdPerson(int id) {
        return personData.findById(id);
    }

    // Guardar nueva persona
    public Person save(Person person) {
        return personData.save(person);  // Devuelvo la persona guardada
    }

    // Actualizar información de una persona existente
    public Person update(int id, Person personUpdate) {
        Optional<Person> personOpt = findByIdPerson(id);  // Busco la persona por ID
        if (personOpt.isPresent()) {
            Person person = personOpt.get();  // Si existe, actualizo sus datos
            person.setFirstName(personUpdate.getFirstName());
            person.setLastName(personUpdate.getLastName());
            person.setEmail(personUpdate.getEmail());
            person.setPhoneNumber(personUpdate.getPhoneNumber());
            person.setAddress(personUpdate.getAddress());
            person.setDeleted(personUpdate.isDeleted());
            return personData.save(person);  // Guardar y devolver la persona actualizada
        }
        return null;  // Si no se encuentra la persona, devuelvo null
    }

    // Eliminar persona
    public void delete(int id) {
        Optional<Person> personOpt = findByIdPerson(id);  // Busco la persona por ID
        personOpt.ifPresent(person -> personData.delete(person));  // Si existe, elimino la persona
    }
}
