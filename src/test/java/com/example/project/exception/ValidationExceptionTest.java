// ValidationExceptionTest.java
package com.example.project.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidationExceptionTest {
    @Test
    void testExceptionMessage() {
        ValidationException ex = new ValidationException("Invalid");
        assertEquals("Invalid", ex.getMessage());
    }
}