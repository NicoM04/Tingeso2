package com.mingeso.msEvaluation.controllers;


import com.mingeso.msEvaluation.requests.CreditEntity;
import com.mingeso.msEvaluation.services.CreditEvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evaluation")
public class CreditEvaluationController {

    @Autowired
    private CreditEvaluationService creditService;

    @PostMapping("/check-income-to-payment-ratio")
    public ResponseEntity<Boolean> checkIncomeToPaymentRatio(@RequestBody CreditEntity credit,
                                                             @RequestParam double monthlyIncome) {
        boolean result = creditService.checkIncomeToPaymentRatio(credit, monthlyIncome);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/check-credit-history")
    public ResponseEntity<Boolean> checkCreditHistory(@RequestParam boolean hasGoodCreditHistory) {
        boolean result = creditService.checkCreditHistory(hasGoodCreditHistory);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/check-employment-stability")
    public ResponseEntity<Boolean> checkEmploymentStability(@RequestParam int employmentYears,
                                                            @RequestParam boolean isSelfEmployed,
                                                            @RequestParam int incomeYears) {
        boolean result = creditService.checkEmploymentStability(employmentYears, isSelfEmployed, incomeYears);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/check-debt-to-income-ratio")
    public ResponseEntity<Boolean> checkDebtToIncomeRatio(@RequestBody CreditEntity credit,
                                                          @RequestParam double totalDebt,
                                                          @RequestParam double monthlyIncome) {
        boolean result = creditService.checkDebtToIncomeRatio(credit, totalDebt, monthlyIncome);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/check-maximum-loan-amount")
    public ResponseEntity<Boolean> checkMaximumLoanAmount(@RequestBody CreditEntity credit,
                                                          @RequestParam double propertyValue) {
        boolean result = creditService.checkMaximumLoanAmount(credit, propertyValue);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/check-applicant-age")
    public ResponseEntity<Boolean> checkApplicantAge(@RequestParam int applicantAge,
                                                     @RequestBody CreditEntity credit) {
        boolean result = creditService.checkApplicantAge(applicantAge, credit);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/evaluate-savings-capacity")
    public ResponseEntity<String> evaluateSavingsCapacity(
            @RequestParam boolean hasMinimumBalance,
            @RequestParam boolean hasConsistentSavings,
            @RequestParam boolean hasRegularDeposits,
            @RequestParam boolean meetsBalanceYears,
            @RequestParam boolean hasNoRecentWithdrawals) {

        String result = creditService.evaluateSavingsCapacity(
                hasMinimumBalance,
                hasConsistentSavings,
                hasRegularDeposits,
                meetsBalanceYears,
                hasNoRecentWithdrawals
        );

        return ResponseEntity.ok(result);
    }
}