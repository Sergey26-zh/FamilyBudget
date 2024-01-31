package com.example.familybudget.service.transaction;

import com.example.familybudget.model.transaction.TransactionType;
import com.example.familybudget.repository.transaction.TransactionTypeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionTypeServiceTest {
    @Mock
    private TransactionTypeRepository transactionTypeRepository;

    @InjectMocks
    private TransactionTypeService transactionTypeService;

    @Test
    public void testDelete() {
        long memberId = 1L;
        TransactionType transactionType = new TransactionType();

        when(transactionTypeRepository.findById(anyLong())).thenReturn(java.util.Optional.of(transactionType));

        boolean result = transactionTypeService.delete(memberId);

        verify(transactionTypeRepository, times(1)).deleteById(transactionType.getId());

        assertTrue(result);
    }

}