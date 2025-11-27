package com.example.account_card_service.controller;

import com.example.account_card_service.model.Account;
import com.example.account_card_service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/{customerId}")
    public Account getAccount(@PathVariable String customerId) {
        return accountService.getAccount(customerId);
    }
}
