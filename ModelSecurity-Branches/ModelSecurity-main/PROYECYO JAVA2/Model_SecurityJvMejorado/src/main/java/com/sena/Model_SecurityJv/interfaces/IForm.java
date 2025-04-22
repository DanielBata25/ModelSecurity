package com.sena.Model_SecurityJv.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.Model_SecurityJv.model.Form;

@Repository
public interface IForm extends JpaRepository<Form, Integer> {
}

