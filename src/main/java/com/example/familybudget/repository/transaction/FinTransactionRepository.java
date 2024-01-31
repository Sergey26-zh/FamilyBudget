package com.example.familybudget.repository.transaction;

import com.example.familybudget.model.transaction.FinancialTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinTransactionRepository extends JpaRepository<FinancialTransaction, Long> {
}
