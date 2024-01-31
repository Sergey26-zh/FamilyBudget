package com.example.familybudget.service.transaction;

import com.example.familybudget.dto.transaction.TransactionTypeDto;
import com.example.familybudget.exception.DataValidException;
import com.example.familybudget.mapper.transaction.TransactionTypeMapper;
import com.example.familybudget.model.transaction.TransactionType;
import com.example.familybudget.model.user.FamilyMember;
import com.example.familybudget.repository.transaction.TransactionTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionTypeService {
    private final TransactionTypeMapper transactionTypeMapper;
    private final TransactionTypeRepository transactionTypeRepository;

    @Transactional
    public TransactionTypeDto create(TransactionTypeDto transactionTypeDto) {
        if (transactionTypeRepository.existsById(transactionTypeDto.getId())) {
            throw new DataValidException("Transaction type already exists");
        }

        TransactionType transactionType = transactionTypeRepository.save(transactionTypeMapper.toEntity(transactionTypeDto));
        return transactionTypeMapper.toDto(transactionType);
    }

    @Transactional
    public boolean delete(long memberId) {
        TransactionType transactionType = validMember(memberId);
        transactionTypeRepository.deleteById(transactionType.getId());
        return true;
    }

    private TransactionType validMember(long id) {
        return transactionTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Family member not found"));
    }
}
