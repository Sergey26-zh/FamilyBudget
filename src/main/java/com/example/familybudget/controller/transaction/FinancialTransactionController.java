package com.example.familybudget.controller.transaction;

import com.example.familybudget.dto.transaction.FinancialTransactionDto;
import com.example.familybudget.service.transaction.FinancialTransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transaction")
@RequiredArgsConstructor
public class FinancialTransactionController {
    private final FinancialTransactionService financialTransactionService;
    @PostMapping
    public FinancialTransactionDto create(FinancialTransactionDto financialTransactionDto) {
        return financialTransactionService.create(financialTransactionDto);
    }
}
