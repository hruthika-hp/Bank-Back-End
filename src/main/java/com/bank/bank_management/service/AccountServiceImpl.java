package com.bank.bank_management.service;

import com.bank.bank_management.dto.AccountDTO;
import com.bank.bank_management.mapper.AccountMapper;
import com.bank.bank_management.model.entity.Account;
import com.bank.bank_management.model.entity.Customer;
import com.bank.bank_management.repository.AccountRepository;
import com.bank.bank_management.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountServiceImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public AccountDTO createAccount(AccountDTO accountDTO) {
        Customer customer = customerRepository.findById(accountDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + accountDTO.getCustomerId()));
        
        Account account = AccountMapper.toEntity(accountDTO, customer);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.toDTO(savedAccount);
    }

    @Override
    public AccountDTO getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        return AccountMapper.toDTO(account);
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(AccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<AccountDTO> getAccountsByCustomerId(Long customerId) {
        List<Account> accounts = accountRepository.findByCustomerId(customerId);
        return accounts.stream()
                .map(AccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AccountDTO updateAccount(Long id, AccountDTO accountDTO) {
        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        
        // Update account fields
        existingAccount.setAccountType(accountDTO.getAccountType());
        existingAccount.setBalance(accountDTO.getBalance());
        
        // If customer ID is being updated, fetch the new customer
        if (!existingAccount.getCustomer().getId().equals(accountDTO.getCustomerId())) {
            Customer customer = customerRepository.findById(accountDTO.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found with id: " + accountDTO.getCustomerId()));
            existingAccount.setCustomer(customer);
        }
        
        Account updatedAccount = accountRepository.save(existingAccount);
        return AccountMapper.toDTO(updatedAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
        
        // Optional: Check if account has transactions before deleting
        // You might want to add business logic here to prevent deletion of accounts with transactions
        
        accountRepository.delete(account);
    }
}