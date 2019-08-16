package com.stop.jeep.testdblock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Transactional
    public Long updateBalance(Long userId, Long amount) throws InterruptedException {
        Account userAccount = accountRepository.findById(userId).get();
        userAccount.setBalance(userAccount.getBalance() + amount);
        Account savedAccount = accountRepository.save(userAccount);
        Thread.sleep(60000);
        return savedAccount.getBalance();
    }

    public Long getAccountBalance(Long userId) {
        return accountRepository.findById(userId).get().getBalance();
    }
}
