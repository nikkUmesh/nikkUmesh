package com.java.banking.service;

import java.util.List;

import com.java.banking.dto.AccountDto;

public interface AccountService {
    AccountDto creteAccount(AccountDto accountdDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id,double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);
}
