package com.bank.bank_management.mapper;



import com.bank.bank_management.dto.AccountDTO;
import com.bank.bank_management.model.entity.Account;
import com.bank.bank_management.model.entity.Customer;

public class AccountMapper {

    public static AccountDTO toDTO(Account account) {
        if (account == null) return null;
        AccountDTO dto = new AccountDTO();
        dto.setId(account.getId());
        dto.setCustomerId(account.getCustomer() != null ? account.getCustomer().getId() : null);
        dto.setAccountType(account.getAccountType());
        dto.setBalance(account.getBalance());
        return dto;
    }

    public static Account toEntity(AccountDTO dto, Customer customer) {
        if (dto == null) return null;
        Account account = new Account();
        account.setId(dto.getId());
        account.setCustomer(customer);
        account.setAccountType(dto.getAccountType());
        account.setBalance(dto.getBalance());
        return account;
    }
}

