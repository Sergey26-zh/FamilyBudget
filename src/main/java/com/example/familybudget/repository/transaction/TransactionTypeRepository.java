package com.example.familybudget.repository.transaction;

import com.example.familybudget.model.transaction.FinancialTransaction;
import com.example.familybudget.model.transaction.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Long> {
}
