package com.mingeso.msRegister.repositories;

import com.mingeso.msRegister.entities.userRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRegisterRepository extends JpaRepository<userRegisterEntity, Long> {
    userRegisterEntity findByRut(String rut);
    userRegisterEntity findByMailAndPassword(String mail, String password);
}