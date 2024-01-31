package com.example.familybudget.mapper.transaction;

import com.example.familybudget.dto.transaction.TransactionTypeDto;
import com.example.familybudget.model.transaction.TransactionType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionTypeMapper {
    TransactionType toEntity(TransactionTypeDto transactionTypeDto);
    TransactionTypeDto toDto(TransactionType transactionType);
}
