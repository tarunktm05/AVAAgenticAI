// ErrorHandlerTest.java
package com.example.project.exception;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

class ErrorHandlerTest {
    private final ErrorHandler handler = new ErrorHandler();

    @Test
    void testHandleNotFound() {
        ResponseEntity<String> resp = handler.handleNotFound(new CustomerNotFoundException("Not found"));
        assertEquals(404, resp.getStatusCodeValue());
        assertEquals("Not found", resp.getBody());
    }
    @Test
    void testHandleValidation() {
        ResponseEntity<String> resp = handler.handleValidation(new ValidationException("Invalid"));
        assertEquals(400, resp.getStatusCodeValue());
        assertEquals("Invalid", resp.getBody());
    }
    @Test
    void testHandleDuplicate() {
        ResponseEntity<String> resp = handler.handleDuplicate(new DuplicateEmailException("Duplicate"));
        assertEquals(409, resp.getStatusCodeValue());
        assertEquals("Duplicate", resp.getBody());
    }
    @Test
    void testHandleUnauthorized() {
        ResponseEntity<String> resp = handler.handleUnauthorized(new UnauthorizedException("Unauthorized"));
        assertEquals(401, resp.getStatusCodeValue());
        assertEquals("Unauthorized", resp.getBody());
    }
    @Test
    void testHandleOther() {
        ResponseEntity<String> resp = handler.handleOther(new Exception("Other"));
        assertEquals(500, resp.getStatusCodeValue());
        assertEquals("Internal server error", resp.getBody());
    }
}