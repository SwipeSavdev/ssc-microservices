package com.example.account_card_service.controller;

import com.example.account_card_service.model.Card;
import com.example.account_card_service.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping("/{customerId}")
    public Card issueCard(@PathVariable String customerId) {
        return cardService.issueCard(customerId);
    }

    @GetMapping("/{customerId}")
    public List<Card> getCards(@PathVariable String customerId) {
        return cardService.getCards(customerId);
    }
}
