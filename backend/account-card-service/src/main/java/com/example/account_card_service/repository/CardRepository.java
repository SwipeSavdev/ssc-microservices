package com.example.account_card_service.repository;

import com.example.account_card_service.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByCustomerId(String customerId);
}
