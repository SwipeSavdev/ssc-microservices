package com.example.account_card_service.service;

import com.example.account_card_service.model.Card;
import com.example.account_card_service.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    public Card issueCard(String customerId) {
        Card card = new Card();
        card.setCustomerId(customerId);
        card.setPan("4111********" + UUID.randomUUID().toString().substring(0, 4));
        card.setStatus("ACTIVE");
        return cardRepository.save(card);
    }

    public List<Card> getCards(String customerId) {
        return cardRepository.findByCustomerId(customerId);
    }
}
