package com.ojt.blog.web.form;

import com.ojt.blog.bl.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountForm {

    private String username;
    private String email;
    private String password;
    public AccountForm(AccountDTO accountDTO) {
        this.username = accountDTO.getUsername();
        this.email = accountDTO.getEmail();
        this.password = accountDTO.getPassword();
    }
}
