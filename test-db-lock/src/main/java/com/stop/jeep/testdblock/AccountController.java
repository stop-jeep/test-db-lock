package com.stop.jeep.testdblock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account")
    public Long getAccount() {
        return accountService.getAccountBalance(1L);
    }

    @PostMapping("/account")
    public Long updateAccount() throws InterruptedException {
        return accountService.updateBalance(1L, 100L);
    }
}
