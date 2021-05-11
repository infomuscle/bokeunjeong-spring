package com.bokeunjeong.portfolio.test.transaction.service;

import com.bokeunjeong.portfolio.repository.PortfolioContactRepository;
import com.bokeunjeong.portfolio.repository.PortfolioProjectRepository;
import com.bokeunjeong.portfolio.test.transaction.model.Account;
import com.bokeunjeong.portfolio.test.transaction.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class TransactionalService {


    private final AccountRepository accountRepository;

    @Autowired
    public TransactionalService(PortfolioContactRepository portfolioContactRepository, PortfolioProjectRepository portfolioProjectRepository, AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account openAccount(Account account) {
        return accountRepository.save(account);
    }

    @Transactional(rollbackFor = {Exception.class})
    public Account deposit(Long accountId, Long amount) throws Exception {

        Optional<Account> target = accountRepository.findById(accountId);
        target.ifPresentOrElse(t -> {
            t.setAmount(t.getAmount() + amount);
            t = accountRepository.save(t);
        }, () -> {
            throw new RuntimeException("No Account Found");
        });

        return target.get();
    }

    @Transactional
    public void transfer(Account sender, Account receiver, Long amount) {

    }

}
