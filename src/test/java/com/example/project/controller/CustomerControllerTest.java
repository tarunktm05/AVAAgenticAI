// CustomerControllerTest.java
package com.example.project.controller;

import com.example.project.dto.CustomerRequest;
import com.example.project.dto.CustomerResponse;
import com.example.project.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerControllerTest {
    private CustomerService customerService;
    private CustomerController controller;

    @BeforeEach
    void setUp() {
        customerService = mock(CustomerService.class);
        controller = new CustomerController(customerService);
    }

    @Test
    void testCreate() {
        CustomerRequest req = new CustomerRequest();
        req.setName("Jane");
        req.setEmail("jane@example.com");
        CustomerResponse resp = new CustomerResponse();
        resp.setId(1L);
        resp.setName("Jane");
        resp.setEmail("jane@example.com");
        when(customerService.createCustomer(req)).thenReturn(resp);
        CustomerResponse result = controller.create(req);
        assertEquals("Jane", result.getName());
    }

    @Test
    void testGet() {
        CustomerResponse resp = new CustomerResponse();
        resp.setId(2L);
        resp.setName("Tom");
        resp.setEmail("tom@example.com");
        when(customerService.getCustomer(2L)).thenReturn(resp);
        CustomerResponse result = controller.get(2L);
        assertEquals(2L, result.getId());
    }

    @Test
    void testGetAll() {
        CustomerResponse resp1 = new CustomerResponse();
        resp1.setId(1L);
        resp1.setName("A");
        resp1.setEmail("a@example.com");
        CustomerResponse resp2 = new CustomerResponse();
        resp2.setId(2L);
        resp2.setName("B");
        resp2.setEmail("b@example.com");
        when(customerService.getAllCustomers()).thenReturn(Arrays.asList(resp1, resp2));
        List<CustomerResponse> result = controller.getAll();
        assertEquals(2, result.size());
    }

    @Test
    void testUpdate() {
        CustomerRequest req = new CustomerRequest();
        req.setName("New");
        req.setEmail("new@example.com");
        CustomerResponse resp = new CustomerResponse();
        resp.setId(3L);
        resp.setName("New");
        resp.setEmail("new@example.com");
        when(customerService.updateCustomer(3L, req)).thenReturn(resp);
        CustomerResponse result = controller.update(3L, req);
        assertEquals("New", result.getName());
    }

    @Test
    void testDelete() {
        doNothing().when(customerService).deleteCustomer(4L);
        controller.delete(4L);
        verify(customerService, times(1)).deleteCustomer(4L);
    }
}