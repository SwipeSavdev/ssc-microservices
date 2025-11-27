package com.example.transaction_rewards_service.service;

import com.example.transaction_rewards_service.model.Reward;
import com.example.transaction_rewards_service.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RewardService {
    @Autowired
    private RewardRepository rewardRepository;

    public void addPoints(String customerId, int points) {
        Reward reward = rewardRepository.findByCustomerId(customerId)
                .orElse(new Reward());
        if (reward.getCustomerId() == null) {
            reward.setCustomerId(customerId);
            reward.setPoints(0);
        }
        reward.setPoints(reward.getPoints() + points);
        rewardRepository.save(reward);
    }
}
