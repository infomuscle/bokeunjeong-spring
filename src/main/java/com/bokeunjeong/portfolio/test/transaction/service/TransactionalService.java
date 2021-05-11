package com.bokeunjeong.portfolio.test.transaction.service;

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
    public TransactionalService(AccountRepository accountRepository) {
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
    public void transfer(Long senderId, Long receiverId, Long amount) throws Exception {

        Account sender = updateSender(senderId, amount);
        Account receiver = updateReceiver(receiverId, amount);

        log.info("Sender: {}", sender);
        log.info("Receiver: {}", receiver);

    }

    private Account updateSender(Long senderId, Long amount) throws Exception {

        Optional<Account> sender = accountRepository.findById(senderId);
        sender.ifPresentOrElse(s -> {
            s.setAmount(s.getAmount() - amount);
            s = accountRepository.save(s);
        }, () -> {
            throw new RuntimeException("No Sender Found");
        });


        return sender.get();
    }

    private Account updateReceiver(Long receiverId, Long amount) throws Exception {

        Optional<Account> receiver = accountRepository.findById(receiverId);
        receiver.ifPresentOrElse(r -> {
            r.setAmount(r.getAmount() + amount);
            r = accountRepository.save(r);
        }, () -> {
            throw new RuntimeException("No Receiver Found");
        });

        return receiver.get();
    }

}
