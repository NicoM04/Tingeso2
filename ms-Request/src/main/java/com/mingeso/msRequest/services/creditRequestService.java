package com.mingeso.msRequest.services;

import com.mingeso.msRequest.entities.creditRequestEntity;
import com.mingeso.msRequest.repositories.creditRequestRepository;
import com.mingeso.msRequest.Clients.UsersFeignClient;
import com.mingeso.msRequest.request.userDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class creditRequestService {

    @Autowired
    public creditRequestRepository creditRequestRepository;

    public UsersFeignClient usersFeignClient;


    public creditRequestEntity getCreditById(Long id) {
        return creditRequestRepository.findById(id).get();
    }

    // Obtener créditos por ID de cliente
    public List<creditRequestEntity> getCreditsByClientId(Long idClient) {
        return creditRequestRepository.findByIdClient(idClient); // Cambiado a idClient
    }
    public ArrayList<creditRequestEntity> getAllCredits() {
        return (ArrayList<creditRequestEntity>) creditRequestRepository.findAll();
    }

    public ArrayList<creditRequestEntity> getCreditByState(int state){
        return (ArrayList<creditRequestEntity>) creditRequestRepository.findByState(state);
    }
    public ArrayList<creditRequestEntity> getCreditByTypeLoan(int type){
        return (ArrayList<creditRequestEntity>) creditRequestRepository.findByTypeLoan(type);
    }
    public creditRequestEntity updateCredit(creditRequestEntity credit) {
        return creditRequestRepository.save(credit);
    }
    public boolean deleteCredit(Long id) throws Exception {
        try{
            creditRequestRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    // Nuevo método para actualizar el estado del crédito
    public creditRequestEntity updateCreditStatus(Long creditId, int newStatus) {
        creditRequestEntity credit = creditRequestRepository.findById(creditId)
                .orElseThrow(() -> new RuntimeException("Crédito no encontrado con ID: " + creditId));
        credit.setState(newStatus);// Actualizar el estado
        return creditRequestRepository.save(credit);// Guardar y devolver el crédito actualizado
    }
    public creditRequestEntity saveCredit(creditRequestEntity credit) {
        // Calcular el pago mensual
        double monthlyPayment = calculateMonthlyPayment(credit.getAmount(), credit.getInterestRate(), credit.getDueDate());
        credit.setMonthlyPayment(monthlyPayment);

        // Calcular el costo total
        double totalCost = calculateTotalCost(monthlyPayment, credit.getDueDate());
        credit.setTotalCost(totalCost);

        // Guardar en la base de datos
        return creditRequestRepository.save(credit);
    }

    private double calculateMonthlyPayment(double loanAmount, double annualInterestRate, int termInYears) {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        int numberOfPayments = termInYears * 12;
        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }

    private double calculateTotalCost(double monthlyPayment, int termInYears) {
        return monthlyPayment * termInYears * 12;
    }

    public userDto getUserByCreditId(Long creditId) {
        creditRequestEntity credit = getCreditById(creditId);
        if (credit == null) {
            throw new RuntimeException("Crédito no encontrado");
        }
        System.out.println("Consultando usuario con ID: " + credit.getIdClient());
        userDto user = usersFeignClient.getUserById(credit.getIdClient());

        return user;
    }
}