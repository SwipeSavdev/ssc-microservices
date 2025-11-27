package com.example.customer_service.service;

import com.example.customer_service.client.FiservClient;
import com.example.customer_service.model.Customer;
import com.example.customer_service.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FiservClient fiservClient;

    public Customer createCustomer(Customer customer) {
        // 1. Create Virtual Account via Fiserv (linked to Tenant FBO)
        String virtualAccount = fiservClient.createVirtualAccount(customer.getTenantId());
        customer.setVirtualAccountId(virtualAccount);

        return customerRepository.save(customer);
    }
}
