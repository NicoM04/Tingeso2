package com.mingeso.msRequest.repositories;


import com.mingeso.msRequest.entities.creditRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface creditRequestRepository extends JpaRepository<creditRequestEntity, Long> {
    creditRequestEntity findById(long id);
    List<creditRequestEntity> findByIdClient(Long idClient); // Cambiado a idClient// Método para encontrar créditos por ID de usuario
    List<creditRequestEntity> findByState(int state);
    List<creditRequestEntity> findByTypeLoan(int type);
}
