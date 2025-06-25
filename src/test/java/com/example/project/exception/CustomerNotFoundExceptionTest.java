// CustomerNotFoundExceptionTest.java
package com.example.project.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerNotFoundExceptionTest {
    @Test
    void testExceptionMessage() {
        CustomerNotFoundException ex = new CustomerNotFoundException("Not found");
        assertEquals("Not found", ex.getMessage());
    }
}