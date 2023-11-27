package com.ojt.blog.bl.service.account.impl;

import com.ojt.blog.bl.dto.AccountDTO;
import com.ojt.blog.bl.service.account.AccountService;
import com.ojt.blog.persistence.entity.Account;

import com.ojt.blog.persistence.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    BCryptPasswordEncoder encoder;
    @Autowired
    AccountRepository accountRepository;
    @Override
    public void registerAccount(AccountDTO accountDTO) {
        var account = new Account(accountDTO);
        account.setPassword(encoder.encode(account.getPassword()));
        accountRepository.save(account);
    }

    @Override
    public AccountDTO getAccountbyUsername(String username) {
        Account account = accountRepository.findByUsername(username);
        return new AccountDTO(account);
    }
}
