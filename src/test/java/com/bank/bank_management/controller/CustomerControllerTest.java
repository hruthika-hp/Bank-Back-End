package com.bank.bank_management.controller;


import com.bank.bank_management.dto.CustomerDTO;
import com.bank.bank_management.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerControllerTest {

    private CustomerService customerService;
    private CustomerController customerController;

    @BeforeEach
    void setUp() {
        customerService = mock(CustomerService.class);
        customerController = new CustomerController(customerService);
    }

    @Test
    void testGetAllCustomers() {
        when(customerService.getAllCustomers()).thenReturn(List.of(new CustomerDTO()));
        List<CustomerDTO> customers = customerController.getAllCustomers();
        assertFalse(customers.isEmpty());
    }

    @Test
    void testCreateCustomer() {
        CustomerDTO dto = new CustomerDTO();
        dto.setName("Bob");
        when(customerService.createCustomer(dto)).thenReturn(dto);

        CustomerDTO result = customerController.createCustomer(dto);
        assertEquals("Bob", result.getName());
    }
}
