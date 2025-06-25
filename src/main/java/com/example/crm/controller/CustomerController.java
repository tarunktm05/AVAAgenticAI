package com.example.crm.controller;

import com.example.crm.dto.CustomerRequestDTO;
import com.example.crm.dto.CustomerResponseDTO;
import com.example.crm.dto.CustomerStatusResponseDTO;
import com.example.crm.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Validated
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerStatusResponseDTO> createCustomer(
            @Valid @RequestBody CustomerRequestDTO request) {
        CustomerStatusResponseDTO response = customerService.createCustomer(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomer(@PathVariable String id) {
        CustomerResponseDTO response = customerService.getCustomerById(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerStatusResponseDTO> updateCustomer(
            @PathVariable String id,
            @Valid @RequestBody CustomerRequestDTO request) {
        CustomerStatusResponseDTO response = customerService.updateCustomer(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomerStatusResponseDTO> deleteCustomer(@PathVariable String id) {
        CustomerStatusResponseDTO response = customerService.deleteCustomer(id);
        return ResponseEntity.ok(response);
    }
}
