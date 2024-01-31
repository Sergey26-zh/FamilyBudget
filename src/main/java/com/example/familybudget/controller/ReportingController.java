package com.example.familybudget.controller;

import com.example.familybudget.dto.transaction.FinancialTransactionDto;
import com.example.familybudget.dto.transaction.TransactionCategoryDto;
import com.example.familybudget.dto.transaction.TransactionTypeDto;
import com.example.familybudget.dto.user.FamilyMemberDto;
import com.example.familybudget.service.ReportingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportingController {
    private final ReportingService reportingService;

    @GetMapping("/betweenDates")
    public List<FinancialTransactionDto> getTransactionsBetweenDates(@RequestParam("startDate") Date startDate,
                                                                     @RequestParam("endDate") Date endDate)
    {
        return reportingService.getTransactionsBetweenDates(startDate, endDate);
    }
    @GetMapping("/byUser")
    public List<FinancialTransactionDto> getTransactionsByUser(@RequestParam("user") FamilyMemberDto user) {
        return reportingService.getTransactionsByUser(user);
    }

    @GetMapping("/byType")
    public List<FinancialTransactionDto> getTransactionsByType(TransactionTypeDto type) {
        return reportingService.getTransactionsByType(type);
    }

    @GetMapping("/byCategory")
    public List<FinancialTransactionDto> getTransactionsByCategory(TransactionCategoryDto category){
        return reportingService.getTransactionsByCategory(category);
    }
}
