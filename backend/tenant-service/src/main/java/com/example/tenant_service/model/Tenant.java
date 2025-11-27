package com.example.tenant_service.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;
    private String apiKey;
    private String fboAccountId;
    private String status; // PENDING, ACTIVE
}
