package com.example.tenant_service.client;

import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class FiservClient {
    public String createFboAccount(String tenantName) {
        // Mock Fiserv API call
        return "FBO-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
