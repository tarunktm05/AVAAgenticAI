package com.example.crm.service;

import com.example.crm.dto.CustomerRequestDTO;
import com.example.crm.dto.CustomerResponseDTO;
import com.example.crm.dto.CustomerStatusResponseDTO;

public interface CustomerService {
    CustomerStatusResponseDTO createCustomer(CustomerRequestDTO request);
    CustomerResponseDTO getCustomerById(String id);
    CustomerStatusResponseDTO updateCustomer(String id, CustomerRequestDTO request);
    CustomerStatusResponseDTO deleteCustomer(String id);
}
