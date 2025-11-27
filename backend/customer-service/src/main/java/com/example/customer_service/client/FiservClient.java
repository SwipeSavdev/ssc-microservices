package com.example.customer_service.client;

import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class FiservClient {
    public String createVirtualAccount(String tenantId) {
        // Mock Fiserv API call to create VA linked to Tenant FBO
        return "VA-" + UUID.randomUUID().toString().substring(0, 12).toUpperCase();
    }
}
