package com.mingeso.msSimulate.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimulationResponse {
    private double monthlyPayment;   // Pago mensual calculado
    private double totalCost;        // Costo total del crédito
}
