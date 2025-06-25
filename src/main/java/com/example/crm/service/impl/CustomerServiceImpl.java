package com.example.crm.service.impl;

import com.example.crm.dto.CustomerRequestDTO;
import com.example.crm.dto.CustomerResponseDTO;
import com.example.crm.dto.CustomerStatusResponseDTO;
import com.example.crm.entity.Customer;
import com.example.crm.exception.CustomerNotFoundException;
import com.example.crm.exception.DuplicateEmailException;
import com.example.crm.repository.CustomerRepository;
import com.example.crm.service.CustomerService;
import com.example.crm.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ValidationUtil validationUtil;

    @Override
    @Transactional
    public CustomerStatusResponseDTO createCustomer(CustomerRequestDTO request) {
        validationUtil.validateCustomer(request);

        customerRepository.findByEmail(request.getEmail()).ifPresent(c -> {
            throw new DuplicateEmailException("Email already exists");
        });

        Customer customer = Customer.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .build();

        Customer saved = customerRepository.save(customer);

        return CustomerStatusResponseDTO.builder()
                .id(saved.getId())
                .status("CREATED")
                .build();
    }

    @Override
    public CustomerResponseDTO getCustomerById(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        return CustomerResponseDTO.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
    }

    @Override
    @Transactional
    public CustomerStatusResponseDTO updateCustomer(String id, CustomerRequestDTO request) {
        validationUtil.validateCustomer(request);

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        if (!customer.getEmail().equals(request.getEmail())) {
            customerRepository.findByEmail(request.getEmail()).ifPresent(c -> {
                throw new DuplicateEmailException("Email already exists");
            });
        }

        customer.setName(request.getName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());

        Customer updated = customerRepository.save(customer);

        return CustomerStatusResponseDTO.builder()
                .id(updated.getId())
                .status("UPDATED")
                .build();
    }

    @Override
    @Transactional
    public CustomerStatusResponseDTO deleteCustomer(String id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        customerRepository.deleteById(id);

        return CustomerStatusResponseDTO.builder()
                .id(customer.getId())
                .status("DELETED")
                .build();
    }
}
