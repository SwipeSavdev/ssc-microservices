package com.example.account_card_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;
    private String pan; // Masked PAN
    private String status; // ACTIVE, BLOCKED
    private String pin; // Hashed
}
