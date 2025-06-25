package com.example.crm.util;

import com.example.crm.dto.CustomerRequestDTO;
import com.example.crm.exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationUtilTest {

    private ValidationUtil validationUtil;

    @BeforeEach
    void setUp() {
        validationUtil = new ValidationUtil();
    }

    @Test
    void testValidCustomer() {
        CustomerRequestDTO req = CustomerRequestDTO.builder().name("John").email("john@example.com").phone("+1234567890").build();
        assertDoesNotThrow(() -> validationUtil.validateCustomer(req));
    }

    @Test
    void testInvalidEmail() {
        CustomerRequestDTO req = CustomerRequestDTO.builder().name("John").email("bademail").phone("+1234567890").build();
        assertThrows(ValidationException.class, () -> validationUtil.validateCustomer(req));
    }
}
