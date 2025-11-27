package com.example.transaction_rewards_service.controller;

import com.example.transaction_rewards_service.model.Transaction;
import com.example.transaction_rewards_service.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.processTransaction(transaction);
    }
}
