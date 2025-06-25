// ResponseBuilderTest.java
package com.example.project.util;

import com.example.project.dto.CustomerResponse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResponseBuilderTest {
    @Test
    void testBuild() {
        CustomerResponse resp = ResponseBuilder.build(1L, "Test", "test@example.com");
        assertEquals(1L, resp.getId());
        assertEquals("Test", resp.getName());
        assertEquals("test@example.com", resp.getEmail());
    }
}