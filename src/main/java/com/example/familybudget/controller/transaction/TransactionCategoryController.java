package com.example.familybudget.controller.transaction;

import com.example.familybudget.dto.transaction.TransactionCategoryDto;
import com.example.familybudget.dto.transaction.TransactionTypeDto;
import com.example.familybudget.service.transaction.TransactionCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction-category")
@RequiredArgsConstructor
public class TransactionCategoryController {
    private final TransactionCategoryService transactionCategoryService;
    @PostMapping
    public TransactionCategoryDto create(@RequestBody TransactionCategoryDto transactionCategoryDto) {
        return transactionCategoryService.create(transactionCategoryDto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        return transactionCategoryService.delete(id);
    }
}
