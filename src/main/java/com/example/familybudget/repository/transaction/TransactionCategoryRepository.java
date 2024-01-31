package com.example.familybudget.repository.transaction;

import com.example.familybudget.model.transaction.TransactionCategory;
import com.example.familybudget.model.transaction.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Long> {
    boolean existsByTransactionTypeAndName(TransactionType transactionType, String name);
}
