package com.mingeso.msEvaluation.requests;

public class CreditEntity {

    private double amount; // Monto del préstamo
    private double monthlyPayment; // Cuota mensual calculada
    private int dueDate; // Años del plazo del préstamo
    private int typeLoan; // Tipo de préstamo
    private boolean hasGoodCreditHistory; // Historial crediticio del solicitante

    // Getters y setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public int getDueDate() {
        return dueDate;
    }

    public void setDueDate(int dueDate) {
        this.dueDate = dueDate;
    }

    public int getTypeLoan() {
        return typeLoan;
    }

    public void setTypeLoan(int typeLoan) {
        this.typeLoan = typeLoan;
    }

    public boolean isHasGoodCreditHistory() {
        return hasGoodCreditHistory;
    }

    public void setHasGoodCreditHistory(boolean hasGoodCreditHistory) {
        this.hasGoodCreditHistory = hasGoodCreditHistory;
    }
}