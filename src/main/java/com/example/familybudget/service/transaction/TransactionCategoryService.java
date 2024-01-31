package com.example.familybudget.service.transaction;

import com.example.familybudget.dto.transaction.TransactionCategoryDto;
import com.example.familybudget.exception.DataValidException;
import com.example.familybudget.mapper.transaction.TransactionCategoryMapper;
import com.example.familybudget.model.transaction.TransactionCategory;
import com.example.familybudget.model.transaction.TransactionType;
import com.example.familybudget.repository.transaction.TransactionCategoryRepository;
import com.example.familybudget.repository.transaction.TransactionTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionCategoryService {
    private final TransactionCategoryRepository transactionCategoryRepository;
    private final TransactionTypeRepository transactionTypeRepository;
    private final TransactionCategoryMapper transactionCategoryMapper;

    @Transactional
    public TransactionCategoryDto create(TransactionCategoryDto transactionCategoryDto, long transactionTypeId) {
        TransactionType transactionType = transactionTypeRepository.findById(transactionTypeId)
                .orElseThrow(() -> new DataValidException("Transaction type not found"));

        if (transactionCategoryRepository.existsByTransactionTypeAndName(transactionType, transactionCategoryDto.getName())) {
            throw new DataValidException("Category with the same name already exists for this transaction type");
        }

        TransactionCategory transactionCategory = TransactionCategory.builder()
                .name(transactionCategoryDto.getName())
                .transactionType(transactionType)
                .build();

        TransactionCategory savedCategory = transactionCategoryRepository.save(transactionCategory);

        return transactionCategoryMapper.toDto(savedCategory);
    }

    @Transactional
    public boolean delete(long memberId) {
        TransactionCategory transactionCategory = validCategory(memberId);
        transactionCategoryRepository.deleteById(transactionCategory.getId());
        return true;
    }

    private TransactionCategory validCategory(long id) {
        return transactionCategoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Transaction category not found"));
    }

}
