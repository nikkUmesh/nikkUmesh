package com.java.banking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.java.banking.dto.AccountDto;
import com.java.banking.entity.Account;
import com.java.banking.mapper.AccountMapper;
import com.java.banking.repository.AccountRepository;
import com.java.banking.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @SuppressWarnings("null")
    @Override
    public AccountDto creteAccount(AccountDto accountdDto) {
        Account account = AccountMapper.mapToAccount(accountdDto);
        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }


    @Override
    public AccountDto getAccountById(Long id) {
       Account account = accountRepository
       .findById(id)
       .orElseThrow(() -> new RuntimeException("Account does not exists"));
    return AccountMapper.mapToAccountDto(account);
    }


    @Override
    public AccountDto deposit(Long id, double amount) {
        Account account = accountRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Account does not exists"));

        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }


    @Override
    public AccountDto withdraw(Long id, double amount) {
        Account account = accountRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Account does not exists"));

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient amount");
        }

        double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount =  accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }


    @Override
    public List<AccountDto> getAllAccounts() {
        
        List <Account> accounts = accountRepository.findAll();
        return accounts.stream().map(account -> AccountMapper.mapToAccountDto(account))
                                                      .collect(Collectors.toList());
        
    }


    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("Account does not exists"));
        accountRepository.deleteById(id); 

    }
    
}
