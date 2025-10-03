package com.bank.bank_management.mapper;

import com.bank.bank_management.dto.TransactionDTO;
import com.bank.bank_management.model.entity.Transaction;
import com.bank.bank_management.model.entity.Account;

public class TransactionMapper {

    public static TransactionDTO toDTO(Transaction transaction) {
        if (transaction == null) return null;
        TransactionDTO dto = new TransactionDTO();
        dto.setId(transaction.getId());
        dto.setAccountId(transaction.getAccount() != null ? transaction.getAccount().getId() : null);
        dto.setType(transaction.getType());
        dto.setAmount(transaction.getAmount());
        dto.setDate(transaction.getDate());
        return dto;
    }

    public static Transaction toEntity(TransactionDTO dto, Account account) {
        if (dto == null) return null;
        Transaction transaction = new Transaction();
        transaction.setId(dto.getId());
        transaction.setAccount(account);
        transaction.setType(dto.getType());
        transaction.setAmount(dto.getAmount());
        transaction.setDate(dto.getDate());
        return transaction;
    }
}