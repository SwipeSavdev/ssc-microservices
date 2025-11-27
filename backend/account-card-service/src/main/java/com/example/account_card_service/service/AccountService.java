package com.example.account_card_service.service;

import com.example.account_card_service.model.Account;
import com.example.account_card_service.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount(String customerId) {
        return accountRepository.findByCustomerId(customerId)
                .orElseGet(() -> createAccount(customerId));
    }

    public Account createAccount(String customerId) {
        Account account = new Account();
        account.setCustomerId(customerId);
        account.setBalance(BigDecimal.ZERO);
        return accountRepository.save(account);
    }
}
