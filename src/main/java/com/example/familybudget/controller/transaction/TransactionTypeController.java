package com.example.familybudget.controller.transaction;

import com.example.familybudget.dto.transaction.TransactionTypeDto;
import com.example.familybudget.service.transaction.TransactionTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction-type")
@RequiredArgsConstructor
public class TransactionTypeController {
    private final TransactionTypeService transactionTypeService;

    @PostMapping
    public TransactionTypeDto create(@RequestBody TransactionTypeDto transactionTypeDto) {
        return transactionTypeService.create(transactionTypeDto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        return transactionTypeService.delete(id);
    }
}
