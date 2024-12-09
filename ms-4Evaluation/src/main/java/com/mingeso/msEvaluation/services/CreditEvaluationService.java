package com.mingeso.msEvaluation.services;

import com.mingeso.msEvaluation.requests.CreditEntity;
import org.springframework.stereotype.Service;

@Service
public class CreditEvaluationService {

    // R1: Relación Cuota/Ingreso
    public boolean checkIncomeToPaymentRatio(CreditEntity credit, double monthlyIncome) {
        double monthlyPayment = credit.getMonthlyPayment();
        double ratio = (monthlyPayment / monthlyIncome) * 100;
        return ratio < 35;
    }

    // R2: Historial Crediticio
    public boolean checkCreditHistory(boolean hasGoodCreditHistory) {
        return hasGoodCreditHistory;
    }

    // R3: Estabilidad Laboral
    public boolean checkEmploymentStability(int employmentYears, boolean isSelfEmployed, int incomeYears) {
        if (isSelfEmployed) {
            return incomeYears >= 2;
        } else {
            return employmentYears >= 1;
        }
    }

    // R4: Relación Deuda/Ingreso
    public boolean checkDebtToIncomeRatio(CreditEntity credit, double totalDebt, double monthlyIncome) {
        double projectedTotalDebt = totalDebt + credit.getMonthlyPayment();
        double maxDebt = monthlyIncome * 0.50;
        return projectedTotalDebt <= maxDebt;
    }

    // R5: Monto Máximo de Financiamiento
    public boolean checkMaximumLoanAmount(CreditEntity credit, double propertyValue) {
        double maxLoanPercentage;
        switch (credit.getTypeLoan()) {
            case 1:
                maxLoanPercentage = 0.80;
                break;
            case 2:
                maxLoanPercentage = 0.70;
                break;
            case 3:
                maxLoanPercentage = 0.60;
                break;
            case 4:
                maxLoanPercentage = 0.50;
                break;
            default:
                throw new IllegalArgumentException("Tipo de préstamo no válido");
        }

        double maxFinanciamiento = propertyValue * maxLoanPercentage;
        return credit.getAmount() <= maxFinanciamiento;
    }

    // R6: Edad del Solicitante
    public boolean checkApplicantAge(int applicantAge, CreditEntity credit) {
        int ageAtLoanEnd = applicantAge + credit.getDueDate();
        return ageAtLoanEnd <= 75;
    }

    // Evaluar capacidad de ahorro
    public String evaluateSavingsCapacity(boolean hasMinimumBalance, boolean hasConsistentSavings,
                                          boolean hasRegularDeposits, boolean meetsBalanceYears,
                                          boolean hasNoRecentWithdrawals) {
        int criteriaMet = 0;

        if (hasMinimumBalance) criteriaMet++;
        if (hasConsistentSavings) criteriaMet++;
        if (hasRegularDeposits) criteriaMet++;
        if (meetsBalanceYears) criteriaMet++;
        if (hasNoRecentWithdrawals) criteriaMet++;

        if (criteriaMet >= 5) {
            return "Sólida";
        } else if (criteriaMet >= 3) {
            return "Moderada";
        } else {
            return "Insuficiente";
        }
    }
}

