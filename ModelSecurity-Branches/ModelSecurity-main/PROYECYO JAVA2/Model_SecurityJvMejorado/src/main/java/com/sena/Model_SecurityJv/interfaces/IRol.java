package com.sena.Model_SecurityJv.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.Model_SecurityJv.model.Rol;

@Repository
public interface IRol extends JpaRepository<Rol, Integer> {
}