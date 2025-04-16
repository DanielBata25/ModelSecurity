package com.sena.Model_SecurityJv.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sena.Model_SecurityJv.model.modules;

@Repository
public interface IModule
extends JpaRepository<modules,Integer>
{

}
