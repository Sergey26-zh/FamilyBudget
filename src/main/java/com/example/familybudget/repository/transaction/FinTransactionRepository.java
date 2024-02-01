package com.example.familybudget.repository.transaction;

import com.example.familybudget.model.transaction.FinancialTransaction;
import com.example.familybudget.model.transaction.TransactionCategory;
import com.example.familybudget.model.transaction.TransactionType;
import com.example.familybudget.model.user.FamilyMember;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FinTransactionRepository extends CrudRepository<FinancialTransaction, Long> {
    List<FinancialTransaction> findAllByDateBetween(Date startDate, Date endDate);
    List<FinancialTransaction> findAllByUser(FamilyMember user);
    List<FinancialTransaction> findAllByType(TransactionType type);
    List<FinancialTransaction> findAllByCategory(TransactionCategory type);
}
