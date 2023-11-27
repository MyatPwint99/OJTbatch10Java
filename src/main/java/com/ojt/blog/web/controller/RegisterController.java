package com.ojt.blog.web.controller;

import com.ojt.blog.bl.dto.AccountDTO;
import com.ojt.blog.bl.service.account.AccountService;
import com.ojt.blog.web.form.AccountForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    AccountService accountService;
    @GetMapping("/register")
    public String registerPage(Model model) {
        // user register
        // username, email, password
        model.addAttribute("accountForm", new AccountForm());
        return "register";
    }
    @PostMapping("/register")
    public String registerAccount(@ModelAttribute AccountForm accountForm) {
        var AccountDTO = new AccountDTO(accountForm);
        accountService.registerAccount(AccountDTO);
        return "redirect:/home";
    }
}
