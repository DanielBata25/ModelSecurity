package com.sena.Model_SecurityJv.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sena.Model_SecurityJv.model.Permission;

@Repository
public interface IPermission extends JpaRepository<Permission, Integer> {
}
