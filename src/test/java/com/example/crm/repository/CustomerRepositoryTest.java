package com.example.crm.repository;

import com.example.crm.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testSaveAndFindByEmail() {
        Customer customer = Customer.builder().name("Jane").email("jane@example.com").phone("+1234567891").build();
        customerRepository.save(customer);
        assertThat(customerRepository.findByEmail("jane@example.com")).isPresent();
    }
}
