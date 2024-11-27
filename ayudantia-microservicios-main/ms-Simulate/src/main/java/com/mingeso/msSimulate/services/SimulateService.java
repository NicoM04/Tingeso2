package com.mingeso.msSimulate.services;



import com.mingeso.msSimulate.requests.SimulationRequest;
import com.mingeso.msSimulate.requests.SimulationResponse;
import org.springframework.stereotype.Service;

@Service
public class SimulateService {

    // Calcula la cuota mensual según la fórmula proporcionada
    public double calculateMonthlyPayment(double loanAmount, double annualInterestRate, int termInYears) {
        double monthlyInterestRate = annualInterestRate / 12 / 100;  // Convertir la tasa anual a tasa mensual
        int numberOfPayments = termInYears * 12;  // Número total de pagos (meses)

        // Fórmula para calcular la cuota mensual
        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }

    public SimulationResponse simulateCredit(SimulationRequest request) {
        // Calcular la cuota mensual
        double monthlyPayment = calculateMonthlyPayment(
                request.getLoanAmount(),
                request.getAnnualInterestRate(),
                request.getLoanTerm()
        );

        // Calcular el costo total
        double totalCost = monthlyPayment * request.getLoanTerm() * 12;

        // Crear la respuesta con los datos calculados
        return new SimulationResponse(
                monthlyPayment,
                totalCost
        );
    }



}
