package com.example.transaction_rewards_service.service;

import com.example.transaction_rewards_service.model.Transaction;
import com.example.transaction_rewards_service.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RewardService rewardService;

    public Transaction processTransaction(Transaction transaction) {
        transaction.setTimestamp(LocalDateTime.now());
        Transaction saved = transactionRepository.save(transaction);

        // Calculate rewards (1 point per $1)
        if (transaction.getAmount().doubleValue() > 0) {
            // Assuming accountId maps to CustomerId for simplicity in this demo
            int points = transaction.getAmount().intValue();
            rewardService.addPoints(transaction.getAccountId(), points);
        }

        return saved;
    }
}
