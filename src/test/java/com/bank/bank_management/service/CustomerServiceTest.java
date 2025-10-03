package com.bank.bank_management.service;


import com.bank.bank_management.dto.CustomerDTO;
import com.bank.bank_management.model.entity.Customer;
import com.bank.bank_management.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    private CustomerRepository customerRepository;
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerRepository = mock(CustomerRepository.class);
        customerService = new CustomerServiceImpl(customerRepository);
    }

    @Test
    void testGetCustomerById() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        CustomerDTO dto = customerService.getCustomerById(1L);
        assertEquals("John Doe", dto.getName());
    }

    @Test
    void testGetAllCustomers() {
        when(customerRepository.findAll()).thenReturn(List.of(new Customer()));
        List<CustomerDTO> customers = customerService.getAllCustomers();
        assertEquals(1, customers.size());
    }

    @Test
    void testCreateCustomer() {
        Customer customer = new Customer();
        customer.setName("Alice");
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        CustomerDTO dto = new CustomerDTO();
        dto.setName("Alice");
        CustomerDTO result = customerService.createCustomer(dto);
        assertEquals("Alice", result.getName());
    }
}
