package com.example.familybudget.dto.transaction;

import com.example.familybudget.model.transaction.TransactionType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransactionCategoryDto {
    private Long id;

    @NotBlank
    private String name;
    private TransactionTypeDto transactionTypeDto;
}
