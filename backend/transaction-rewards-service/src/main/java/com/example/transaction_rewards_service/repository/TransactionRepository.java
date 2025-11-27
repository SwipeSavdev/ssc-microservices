package com.example.transaction_rewards_service.repository;

import com.example.transaction_rewards_service.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
