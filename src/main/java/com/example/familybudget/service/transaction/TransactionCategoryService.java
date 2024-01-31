package com.example.familybudget.service.transaction;

import com.example.familybudget.dto.transaction.TransactionCategoryDto;
import com.example.familybudget.exception.DataValidException;
import com.example.familybudget.mapper.transaction.TransactionCategoryMapper;
import com.example.familybudget.model.transaction.TransactionCategory;
import com.example.familybudget.model.transaction.TransactionType;
import com.example.familybudget.repository.transaction.TransactionCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionCategoryService {
    private final TransactionCategoryRepository transactionCategoryRepository;
    private final TransactionCategoryMapper transactionCategoryMapper;

    @Transactional
    public TransactionCategoryDto create(TransactionCategoryDto transactionCategoryDto) {
        if (transactionCategoryRepository.existsById(transactionCategoryDto.getId())) {
            throw new DataValidException("Transaction type already exists");
        }

        TransactionCategory transactionCategory = transactionCategoryRepository.save(transactionCategoryMapper.toEntity(transactionCategoryDto));
        return transactionCategoryMapper.toDto(transactionCategory);
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
