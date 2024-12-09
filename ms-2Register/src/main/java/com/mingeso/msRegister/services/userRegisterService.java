package com.mingeso.msRegister.services;

import com.mingeso.msRegister.entities.userRegisterEntity;
import com.mingeso.msRegister.repositories.userRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class userRegisterService {
    @Autowired
    private userRegisterRepository userRegisterRepository;

    public ArrayList<userRegisterEntity> getUsers() {
        return (ArrayList<userRegisterEntity>) userRegisterRepository.findAll();
    }

    public userRegisterEntity getUserById(Long id) {
        return userRegisterRepository.findById(id).orElse(null);
    }

    public userRegisterEntity getUserByRut(String rut) {
        return userRegisterRepository.findByRut(rut);
    }

    public userRegisterEntity saveUser(userRegisterEntity user) {
        return userRegisterRepository.save(user);
    }

    public userRegisterEntity updateUser(userRegisterEntity user) {
        return userRegisterRepository.save(user);
    }

    public boolean deleteUser(Long id) throws Exception {
        try {
            userRegisterRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public userRegisterEntity login(String mail, String password) {
        return userRegisterRepository.findByMailAndPassword(mail, password);
    }
}

