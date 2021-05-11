package com.bokeunjeong.portfolio;

import com.bokeunjeong.portfolio.test.transaction.model.Account;
import com.bokeunjeong.portfolio.test.transaction.service.TransactionalService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@Transactional
@SpringBootTest
@DisplayName("@Transactional 테스트")
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TransactionalServiceTest {

    @Autowired
    TransactionalService transactionalService;

    private final Logger log = (Logger) LoggerFactory.getLogger(TransactionalServiceTest.class);

    @Test
    @DisplayName("1. 트랜잭션 메소드 안에서 1개 insert 실행 중 예외")
    public void _01_testTransaction() {

        Account account = transactionalService.openAccount(new Account(100000L));
        log.info("Account Opened: {}", account);

        try {
            transactionalService.deposit(account.getId(), 99999L);
            log.info("Deposit Succeeded: {}", account);
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        }

    }

    @Test
    @DisplayName("2. 트랜잭션 메소드 안에서 n개 insert 실행 중 예외")
    public void _02_testTransaction() {

        Account sender = transactionalService.openAccount(new Account(100000L));
        Account receiver = transactionalService.openAccount(new Account(0L));

        try {
//            transactionalService.transfer(sender.getId(), receiver.getId(), 50000L);
//            transactionalService.transfer(sender.getId(), 999L, 50000L);
            transactionalService.transfer(sender.getId(), 777L, 50000L);
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        }

    }


    @Test
    @DisplayName("3. 논트랜잭션 메소드 안에서 1개 insert 실행 중 예외")
    public void _03_test() {

    }

}
