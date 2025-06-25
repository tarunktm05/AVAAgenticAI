// DuplicateEmailExceptionTest.java
package com.example.project.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DuplicateEmailExceptionTest {
    @Test
    void testExceptionMessage() {
        DuplicateEmailException ex = new DuplicateEmailException("Duplicate");
        assertEquals("Duplicate", ex.getMessage());
    }
}