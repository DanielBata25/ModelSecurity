package com.sena.Model_SecurityJv.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Model_SecurityJv.interfaces.IUser;
import com.sena.Model_SecurityJv.model.User;

@Service
public class UserService {

    @Autowired
    private IUser userData;

    // Obtener todos los usuarios
    public List<User> findAllUsers() {
        return userData.findAll();
    }

    // Buscar usuario por ID
    public Optional<User> findByIdUser(int id) {
        return userData.findById(id);
    }

    // Guardar nuevo usuario
    public User save(User user) {
        return userData.save(user);  // Devuelvo el usuario guardado
    }

    // Actualizar información de un usuario existente
    public User update(int id, User userUpdate) {
        Optional<User> userOpt = findByIdUser(id);  // Busco el usuario por ID
        if (userOpt.isPresent()) {
            User user = userOpt.get();  // Si existe, actualizo sus datos
            user.setUserName(userUpdate.getUserName());
            user.setActive(userUpdate.isActive());
            user.setPassword(userUpdate.getPassword());
            user.setDeleted(userUpdate.isDeleted());
            user.setPerson(userUpdate.getPerson());
            return userData.save(user);  // Guardar y devolver el usuario actualizado
        }
        return null;  // Si no se encuentra el usuario, devuelvo null
    }

    // Eliminar usuario
    public void delete(int id) {
        Optional<User> userOpt = findByIdUser(id);  // Busco el usuario por ID
        userOpt.ifPresent(user -> userData.delete(user));  // Si existe, elimino el usuario
    }
}
