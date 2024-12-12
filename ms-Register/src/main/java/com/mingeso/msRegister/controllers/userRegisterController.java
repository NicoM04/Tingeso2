package com.mingeso.msRegister.controllers;


import com.mingeso.msRegister.entities.userRegisterEntity;
import com.mingeso.msRegister.services.userRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class userRegisterController {
    @Autowired
    private userRegisterService userRegisterService;

    @GetMapping("/")
    public ResponseEntity<List<userRegisterEntity>> listAllUsers() {
        List<userRegisterEntity> users = userRegisterService.getUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<userRegisterEntity> getUserById(@PathVariable Long id) {
        userRegisterEntity user = userRegisterService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/")
    public ResponseEntity<userRegisterEntity> saveUser(@RequestBody userRegisterEntity user) {
        userRegisterEntity newUser = userRegisterService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/")
    public ResponseEntity<userRegisterEntity> updateUser(@RequestBody userRegisterEntity user) {
        userRegisterEntity updatedUser = userRegisterService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) throws Exception {
        userRegisterService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<userRegisterEntity> login(@RequestBody userRegisterEntity user) {
        userRegisterEntity loggedInUser = userRegisterService.login(user.getMail(), user.getPassword());
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.status(401).body(null);
        }
    }
}
