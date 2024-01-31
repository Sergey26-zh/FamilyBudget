package com.example.familybudget.dto.transaction;

import com.example.familybudget.model.transaction.TransactionCategory;
import com.example.familybudget.model.transaction.TransactionType;
import com.example.familybudget.model.user.FamilyMember;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FinancialTransactionDto {
    private Double amount;
    private Date date;
    private FamilyMember user;
    private TransactionType type;
    private TransactionCategory category;
}
