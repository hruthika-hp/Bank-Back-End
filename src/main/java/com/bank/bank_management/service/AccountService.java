package com.bank.bank_management.service;

import com.bank.bank_management.dto.AccountDTO;
import java.util.List;

public interface AccountService {
    AccountDTO createAccount(AccountDTO accountDTO);
    AccountDTO getAccountById(Long id);
    List<AccountDTO> getAllAccounts();
    List<AccountDTO> getAccountsByCustomerId(Long customerId);
    AccountDTO updateAccount(Long id, AccountDTO accountDTO);
    void deleteAccount(Long id);
}