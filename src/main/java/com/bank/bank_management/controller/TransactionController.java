package com.bank.bank_management.controller;

import com.bank.bank_management.dto.TransactionDTO;
import com.bank.bank_management.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit/{accountId}")
    public TransactionDTO deposit(@PathVariable Long accountId, @RequestParam Double amount) {
        return transactionService.deposit(accountId, amount);
    }

    @PostMapping("/withdraw/{accountId}")
    public TransactionDTO withdraw(@PathVariable Long accountId, @RequestParam Double amount) {
        return transactionService.withdraw(accountId, amount);
    }

    @GetMapping("/account/{accountId}")
    public List<TransactionDTO> getTransactions(@PathVariable Long accountId) {
        return transactionService.getTransactionsByAccountId(accountId);
    }
}
