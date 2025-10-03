package com.bank.bank_management.repository;


import com.bank.bank_management.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    // Add custom queries here if needed
}
