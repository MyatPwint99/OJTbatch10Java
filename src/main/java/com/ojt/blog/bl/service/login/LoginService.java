package com.ojt.blog.bl.service.login;

import com.ojt.blog.bl.dto.AuthUser;
import com.ojt.blog.persistence.entity.Account;

import com.ojt.blog.persistence.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Account account = accountRepository.findByUsername(username);
            return new AuthUser(account);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }
}