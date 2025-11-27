package com.example.transaction_rewards_service.repository;

import com.example.transaction_rewards_service.model.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RewardRepository extends JpaRepository<Reward, Long> {
    Optional<Reward> findByCustomerId(String customerId);
}
