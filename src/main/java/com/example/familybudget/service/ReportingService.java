package com.example.familybudget.service;

import com.example.familybudget.dto.transaction.FinancialTransactionDto;
import com.example.familybudget.dto.transaction.TransactionCategoryDto;
import com.example.familybudget.dto.transaction.TransactionTypeDto;
import com.example.familybudget.dto.user.FamilyMemberDto;
import com.example.familybudget.mapper.transaction.FinancialTransactionMapper;
import com.example.familybudget.mapper.transaction.TransactionCategoryMapper;
import com.example.familybudget.mapper.transaction.TransactionTypeMapper;
import com.example.familybudget.mapper.user.FamilyMemberMapper;
import com.example.familybudget.model.transaction.FinancialTransaction;
import com.example.familybudget.model.transaction.TransactionCategory;
import com.example.familybudget.model.transaction.TransactionType;
import com.example.familybudget.model.user.FamilyMember;
import com.example.familybudget.repository.transaction.FinTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportingService {
    private final FinTransactionRepository transactionRepository;
    private final FinancialTransactionMapper financialTransactionMapper;
    private final FamilyMemberMapper familyMemberMapper;
    private final TransactionCategoryMapper transactionCategoryMapper;
    private final TransactionTypeMapper transactionTypeMapper;

    public List<FinancialTransactionDto> getTransactionsBetweenDates(Date startDate, Date endDate) {
        validateDates(startDate, endDate);
        List<FinancialTransaction> financialTransactions = transactionRepository.findAllByDateBetween(startDate, endDate);

        return financialTransactionMapper.toListDto(financialTransactions);
    }

    public List<FinancialTransactionDto> getTransactionsByUser(FamilyMemberDto user) {
        validateUser(familyMemberMapper.toEntity(user));
        return financialTransactionMapper.toListDto(
                transactionRepository.findAllByUser(familyMemberMapper.toEntity(user))
        );
    }

    public List<FinancialTransactionDto> getTransactionsByType(TransactionTypeDto type) {
        validateType(transactionTypeMapper.toEntity(type));
        return financialTransactionMapper.toListDto(
                transactionRepository.findAllByType(transactionTypeMapper.toEntity(type))
        );
    }

    public List<FinancialTransactionDto> getTransactionsByCategory(TransactionCategoryDto category) {
        validateCategory(transactionCategoryMapper.toEntity(category));

        return financialTransactionMapper.toListDto(
                transactionRepository.findAllByCategory(transactionCategoryMapper.toEntity(category))
        );
    }

    private void validateDates(Date startDate, Date endDate) {
        if (startDate == null || endDate == null || startDate.after(endDate)) {
            throw new IllegalArgumentException("Invalid date range");
        }
    }

    private void validateUser(FamilyMember user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
    }

    private void validateType(TransactionType type) {
        if (type == null || type.getName() == null || type.getName().isEmpty()) {
            throw new IllegalArgumentException("Transaction type cannot be null");
        }
    }

    private void validateCategory(TransactionCategory category) {
        if (category == null || category.getName() == null || category.getName().isEmpty()) {
            throw new IllegalArgumentException("Invalid category");
        }
    }
}
