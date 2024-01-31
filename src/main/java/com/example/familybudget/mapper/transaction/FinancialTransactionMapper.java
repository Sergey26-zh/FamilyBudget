package com.example.familybudget.mapper.transaction;

import com.example.familybudget.dto.transaction.FinancialTransactionDto;
import com.example.familybudget.model.transaction.FinancialTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FinancialTransactionMapper {
    FinancialTransaction toEntity(FinancialTransactionDto financialTransactionDto);
    FinancialTransactionDto toDto(FinancialTransaction financialTransaction);
    List<FinancialTransaction> toListEntity(List<FinancialTransactionDto> financialTransactionDto);
    List<FinancialTransactionDto> toListDto(List<FinancialTransaction> financialTransactions);
}
