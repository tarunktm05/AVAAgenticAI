// CustomerRequestTest.java
package com.example.project.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerRequestTest {
    @Test
    void testGettersAndSetters() {
        CustomerRequest req = new CustomerRequest();
        req.setName("Alice");
        req.setEmail("alice@example.com");
        assertEquals("Alice", req.getName());
        assertEquals("alice@example.com", req.getEmail());
    }
}