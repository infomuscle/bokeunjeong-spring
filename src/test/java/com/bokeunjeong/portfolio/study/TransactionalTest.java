package com.bokeunjeong.portfolio.study;

import com.bokeunjeong.portfolio.test.transaction.model.Account;
import com.bokeunjeong.portfolio.test.transaction.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@Transactional
@SpringBootTest
@DisplayName("@Transactional 테스트")
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TransactionalTest {

    @Autowired
    AccountService accountService;

    private final Logger log = (Logger) LoggerFactory.getLogger(TransactionalTest.class);


    @Test
    @DisplayName("이체: 정상")
    public void _11_testTransferTransaction() throws Exception {

        Account sender = accountService.openAccount(new Account(100000L));
        Account receiver = accountService.openAccount(new Account(0L));

        Map<String, Account> result = accountService.transfer(sender.getId(), receiver.getId(), 50000L);

        assertThat(result.get("sender").getAmount()).isEqualTo(50000L);
        assertThat(result.get("receiver").getAmount()).isEqualTo(50000L);
    }

    @Test
    @DisplayName("이체: 송금인 업데이트 후 예상못한 Unchecked Exception")
    public void _12_testTransferTransaction2() {

        Account sender = accountService.openAccount(new Account(100000L));
        Account receiver = accountService.openAccount(new Account(0L));

        Exception e = assertThrows(Exception.class, () -> {
            accountService.transfer(sender.getId(), null, 50000L);
        });

        assertThat(e.getClass().getSimpleName()).isEqualTo("NullPointerException");
        assertThat(accountService.getAccount(sender.getId()).getAmount()).isEqualTo(100000L);
        assertThat(accountService.getAccount(receiver.getId()).getAmount()).isEqualTo(0L);
    }

    @Test
    @DisplayName("이체: 송금인 업데이트 후 의도적인 Unchecked Exception")
    public void _13_testTransferTransaction3() {

        Account sender = accountService.openAccount(new Account(100000L));
        Account receiver = accountService.openAccount(new Account(0L));

        Exception e = assertThrows(Exception.class, () -> {
            accountService.transfer(sender.getId(), 777L, 50000L);
        });

        assertThat(e.getMessage()).isEqualTo("Intentional RuntimeException");
        assertThat(accountService.getAccount(sender.getId()).getAmount()).isEqualTo(100000L);
        assertThat(accountService.getAccount(receiver.getId()).getAmount()).isEqualTo(0L);
    }

    @Test
    @DisplayName("이체: 송금인 업데이트 후 의도적인 Checked Exception")
    public void _14_testTransferTransaction4() {

        Account sender = accountService.openAccount(new Account(100000L));
        Account receiver = accountService.openAccount(new Account(0L));

        Exception e = assertThrows(Exception.class, () -> {
            accountService.transfer(sender.getId(), 555L, 50000L);
        });

        assertThat(e.getMessage()).isEqualTo("Intentional ClassNotFoundException");
        assertThat(accountService.getAccount(sender.getId()).getAmount()).isEqualTo(50000L);
        assertThat(accountService.getAccount(receiver.getId()).getAmount()).isEqualTo(0L);
    }

}
