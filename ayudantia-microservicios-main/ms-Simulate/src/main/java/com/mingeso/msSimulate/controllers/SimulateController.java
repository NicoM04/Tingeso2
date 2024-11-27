package com.mingeso.msSimulate.controllers;
import com.mingeso.msSimulate.requests.SimulationRequest;
import com.mingeso.msSimulate.requests.SimulationResponse;

import com.mingeso.msSimulate.services.SimulateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simulate")
@CrossOrigin("*")
public class SimulateController {


    private final SimulateService simulateService;

    public SimulateController(SimulateService simulateService) {
        this.simulateService = simulateService;
    }

    // Controlador para manejar simulaciones de crédito
    @PostMapping("/simulate")
    public ResponseEntity<?> simulateCredit(@RequestBody SimulationRequest simulationRequest) {
        // Validación de los datos de entrada
        if (simulationRequest.getLoanAmount() <= 0 ||
                simulationRequest.getAnnualInterestRate() <= 0 ||
                simulationRequest.getLoanTerm() <= 0) {
            return ResponseEntity.badRequest().body("Los valores ingresados deben ser mayores que cero.");
        }

        try {
            // Realizar la simulación utilizando el servicio
            SimulationResponse simulatedResult = simulateService.simulateCredit(simulationRequest);

            // Devolver el resultado de la simulación
            return ResponseEntity.ok(simulatedResult);
        } catch (Exception ex) {
            // Manejar errores inesperados
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ocurrió un error al realizar la simulación: " + ex.getMessage());
        }
    }

}
