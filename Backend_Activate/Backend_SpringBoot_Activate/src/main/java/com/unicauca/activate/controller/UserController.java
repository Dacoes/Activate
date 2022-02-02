package com.unicauca.activate.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.unicauca.activate.model.User;
import com.unicauca.activate.service.IUserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

/**
 * Clase controladora de usuario
 */
@RestController
@RequestMapping("/activate")
public class UserController {

    @Autowired
    private IUserService UserService;
    
    //Crear Usuario
    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);
        User save = UserService.save(user);
        return ResponseEntity.ok().body(save);
    }

    //Leer Usuario
    @GetMapping("user/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {

        Optional<User> oUser = UserService.findById(id);

        if (!oUser.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(oUser);
    }

    //Actualizar Usuario
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@RequestBody User userDetails, @PathVariable(value = "id") Long userId) {
        Optional<User> user = UserService.findById(userId);

        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        user.get().setName(userDetails.getName());
        user.get().setLastName(userDetails.getLastName());
        user.get().setEmail(userDetails.getEmail());
        user.get().setPassword(userDetails.getPassword());

        return ResponseEntity.status(HttpStatus.CREATED).body(UserService.save(user.get()));
    }

    //Borrar Usuario
    @DeleteMapping("remove/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId) {
        if (!UserService.findById(userId).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        UserService.deleteById(userId);
        return ResponseEntity.ok().build();
    }

    //Obtener todos los usuarios
    @GetMapping("users/all")
    public List<User> readAll() {
        List<User> users = StreamSupport
                .stream(UserService.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return users;
    }
}
