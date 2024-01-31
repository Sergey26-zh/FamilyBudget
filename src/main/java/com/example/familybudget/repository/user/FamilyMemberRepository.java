package com.example.familybudget.repository.user;

import com.example.familybudget.model.user.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {
}
