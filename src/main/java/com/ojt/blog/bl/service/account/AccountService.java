package com.ojt.blog.bl.service.account;

import com.ojt.blog.bl.dto.AccountDTO;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    void registerAccount(AccountDTO accountDTO);

    AccountDTO getAccountbyUsername(String username);
}
