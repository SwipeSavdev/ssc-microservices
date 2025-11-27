package com.example.transaction_rewards_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerId;
    private int points;
}
