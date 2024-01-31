package com.example.familybudget.mapper.transaction;

import com.example.familybudget.dto.transaction.TransactionCategoryDto;
import com.example.familybudget.dto.transaction.TransactionTypeDto;
import com.example.familybudget.model.transaction.TransactionCategory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionCategoryMapper {
    TransactionCategory toEntity(TransactionCategoryDto transactionCategoryDto);
    TransactionCategoryDto toDto(TransactionCategory transactionCategory);
}
