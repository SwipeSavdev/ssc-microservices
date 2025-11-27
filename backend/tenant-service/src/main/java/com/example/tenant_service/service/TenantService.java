package com.example.tenant_service.service;

import com.example.tenant_service.client.FiservClient;
import com.example.tenant_service.model.Tenant;
import com.example.tenant_service.repository.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TenantService {
    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private FiservClient fiservClient;

    public Tenant createTenant(Tenant tenant) {
        // 1. Create FBO Account via Fiserv
        String fboAccount = fiservClient.createFboAccount(tenant.getName());
        tenant.setFboAccountId(fboAccount);
        tenant.setStatus("ACTIVE");

        // 2. Save Tenant
        return tenantRepository.save(tenant);
    }

    public List<Tenant> getAllTenants() {
        return tenantRepository.findAll();
    }
}
