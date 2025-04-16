package com.sena.Model_SecurityJv.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sena.Model_SecurityJv.model.permissions;

public interface IPermissions extends JpaRepository<permissions, Integer> {
}
