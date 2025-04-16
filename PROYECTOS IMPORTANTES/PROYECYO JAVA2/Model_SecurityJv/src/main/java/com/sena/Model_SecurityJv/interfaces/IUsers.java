package com.sena.Model_SecurityJv.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.Model_SecurityJv.model.users;

@Repository
public interface IUsers extends JpaRepository<users, Integer> {
    // Aquí puedes agregar métodos personalizados si los necesitas más adelante
}
