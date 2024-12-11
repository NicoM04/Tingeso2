package com.mingeso.msSimulate.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimulationRequest {
    private double loanAmount;       // Monto del préstamo
    private int loanTerm;            // Plazo en años
    private double annualInterestRate; // Tasa de interés anual
}