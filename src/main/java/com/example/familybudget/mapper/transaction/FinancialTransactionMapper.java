package com.example.familybudget.mapper.transaction;

import com.example.familybudget.dto.transaction.FinancialTransactionDto;
import com.example.familybudget.model.transaction.FinancialTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FinancialTransactionMapper {
    FinancialTransaction toEntity(FinancialTransactionDto financialTransactionDto);
    FinancialTransactionDto toDto(FinancialTransaction financialTransaction);
}
