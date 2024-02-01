package com.example.familybudget.repository.user;

import com.example.familybudget.model.transaction.FinancialTransaction;
import com.example.familybudget.model.user.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamilyMemberRepository extends CrudRepository<FamilyMember, Long> {
}
