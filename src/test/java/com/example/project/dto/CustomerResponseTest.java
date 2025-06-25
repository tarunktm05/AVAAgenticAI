// CustomerResponseTest.java
package com.example.project.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerResponseTest {
    @Test
    void testGettersAndSetters() {
        CustomerResponse resp = new CustomerResponse();
        resp.setId(2L);
        resp.setName("Bob");
        resp.setEmail("bob@example.com");
        assertEquals(2L, resp.getId());
        assertEquals("Bob", resp.getName());
        assertEquals("bob@example.com", resp.getEmail());
    }
}