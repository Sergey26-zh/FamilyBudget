package com.example.familybudget.model.transaction;

import com.example.familybudget.model.user.FamilyMember;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private FamilyMember user;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id")
    private TransactionType type;

    @ManyToOne
    @JoinColumn(name = "transaction_category_id")
    private TransactionCategory category;
}