package com.example.crm.controller;

import com.example.crm.dto.CustomerRequestDTO;
import com.example.crm.dto.CustomerStatusResponseDTO;
import com.example.crm.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateCustomer() {
        CustomerRequestDTO req = CustomerRequestDTO.builder().name("John").email("john@example.com").phone("+1234567890").build();
        CustomerStatusResponseDTO resp = CustomerStatusResponseDTO.builder().id("1").status("CREATED").build();
        when(customerService.createCustomer(req)).thenReturn(resp);
        ResponseEntity<CustomerStatusResponseDTO> response = customerController.createCustomer(req);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(resp, response.getBody());
    }
}
