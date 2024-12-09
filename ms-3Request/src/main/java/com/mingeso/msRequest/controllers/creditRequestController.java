package com.mingeso.msRequest.controllers;


import com.mingeso.msRequest.entities.creditRequestEntity;
import com.mingeso.msRequest.services.creditRequestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/credit")
@CrossOrigin("*")
public class creditRequestController {

    @Autowired
    private creditRequestService creditService;

    @GetMapping("/")
    public ResponseEntity<List<creditRequestEntity>> getAllCredits() {
        List<creditRequestEntity> credit = creditService.getAllCredits();
        return ResponseEntity.ok(credit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<creditRequestEntity> getCreditById(@PathVariable("id") Long id) {
        System.out.println("Request received for Credit ID: " + id); // Imprime el ID recibido
        try {
            creditRequestEntity credit = creditService.getCreditById(id);
            System.out.println("Credit found: " + credit); // Imprime el objeto CreditEntity encontrado
            return ResponseEntity.ok(credit);
        } catch (Exception e) {
            System.err.println("Error occurred while fetching Credit: " + e.getMessage()); // Imprime el error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    // Obtener créditos por ID de cliente
    @GetMapping("/client/{idClient}") // Cambiado a idClient
    public ResponseEntity<List<creditRequestEntity>> getCreditsByClientId(@PathVariable Long idClient) {
        List<creditRequestEntity> credits = creditService.getCreditsByClientId(idClient);
        return ResponseEntity.ok(credits);
    }
    @PostMapping("/")
    public ResponseEntity<creditRequestEntity> saveCredit(@RequestBody creditRequestEntity credit) {
        creditRequestEntity savedCredit = creditService.saveCredit(credit);
        return ResponseEntity.ok(savedCredit);
    }


    @PutMapping("/")
    public ResponseEntity<creditRequestEntity> updateCredit(@RequestBody creditRequestEntity credit){
        creditRequestEntity creditUpdated = creditService.updateCredit(credit);
        return ResponseEntity.ok(creditUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCreditById(@PathVariable Long id) throws Exception {
        var isDeleted = creditService.deleteCredit(id);
        return ResponseEntity.noContent().build();
    }
}