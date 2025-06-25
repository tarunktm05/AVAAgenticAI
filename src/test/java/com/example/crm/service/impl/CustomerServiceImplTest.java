package com.example.crm.service.impl;

import com.example.crm.dto.CustomerRequestDTO;
import com.example.crm.dto.CustomerStatusResponseDTO;
import com.example.crm.entity.Customer;
import com.example.crm.exception.CustomerNotFoundException;
import com.example.crm.repository.CustomerRepository;
import com.example.crm.util.ValidationUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private ValidationUtil validationUtil;
    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCustomer() {
        CustomerRequestDTO req = CustomerRequestDTO.builder().name("John").email("john@example.com").phone("+1234567890").build();
        when(customerRepository.findByEmail("john@example.com")).thenReturn(Optional.empty());
        Customer saved = Customer.builder().id("1").name("John").email("john@example.com").phone("+1234567890").build();
        when(customerRepository.save(any())).thenReturn(saved);
        CustomerStatusResponseDTO resp = customerService.createCustomer(req);
        assertEquals("1", resp.getId());
        assertEquals("CREATED", resp.getStatus());
    }

    @Test
    void testDeleteCustomerNotFound() {
        when(customerRepository.findById("999")).thenReturn(Optional.empty());
        assertThrows(CustomerNotFoundException.class, () -> customerService.deleteCustomer("999"));
    }
}
