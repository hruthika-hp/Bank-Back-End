package com.bank.bank_management.service;

import com.bank.bank_management.dto.TransactionDTO;
import java.util.List;

public interface TransactionService {
    TransactionDTO deposit(Long accountId, Double amount);
    TransactionDTO withdraw(Long accountId, Double amount);
    List<TransactionDTO> getTransactionsByAccountId(Long accountId);
}