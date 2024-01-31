package com.example.familybudget.service.transaction;

import com.example.familybudget.dto.transaction.FinancialTransactionDto;
import com.example.familybudget.mapper.transaction.FinancialTransactionMapper;
import com.example.familybudget.model.transaction.FinancialTransaction;
import com.example.familybudget.model.transaction.TransactionType;
import com.example.familybudget.repository.transaction.FinTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FinancialTransactionService {
    private final FinTransactionRepository finTransactionRepository;
    private final FinancialTransactionMapper financialTransactionMapper;

    @Transactional
    public FinancialTransactionDto create(FinancialTransactionDto financialTransactionDto) {
        FinancialTransaction financialTransaction = finTransactionRepository.
                save(financialTransactionMapper.toEntity(financialTransactionDto));
        return financialTransactionMapper.toDto(financialTransaction);
    }
}
