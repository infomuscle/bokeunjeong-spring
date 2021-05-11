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

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//@Transactional
@SpringBootTest
@DisplayName("@Transactional 테스트")
@TestMethodOrder(MethodOrderer.MethodName.class)
public class TransactionalServiceTest {

    @Autowired
    TransactionalService transactionalService;

    private final Logger log = (Logger) LoggerFactory.getLogger(TransactionalServiceTest.class);


    @Test
    @DisplayName("이체: 정상")
    public void _11_testTransferTransaction() throws Exception {

        Account sender = transactionalService.openAccount(new Account(100000L));
        Account receiver = transactionalService.openAccount(new Account(0L));

        Map<String, Account> result = transactionalService.transfer(sender.getId(), receiver.getId(), 50000L);

        assertThat(result.get("sender").getAmount()).isEqualTo(50000L);
        assertThat(result.get("receiver").getAmount()).isEqualTo(50000L);
    }

    @Test
    @DisplayName("이체: 송금인 업데이트 후 Unchecked Exception")
    public void _12_testTransferTransaction2() {

        Account sender = transactionalService.openAccount(new Account(100000L));
        Account receiver = transactionalService.openAccount(new Account(0L));

        Exception e = assertThrows(Exception.class, () -> {
            transactionalService.transfer(sender.getId(), 999L, 50000L);
        });

        assertThat(e.getMessage()).isEqualTo("No Receiver Found");
        assertThat(transactionalService.getAccount(sender.getId()).getAmount()).isEqualTo(100000L);
        assertThat(transactionalService.getAccount(receiver.getId()).getAmount()).isEqualTo(0L);
    }

    @Test
    @DisplayName("이체: 송금인 업데이트 후 의도적인 Unchecked Exception")
    public void _13_testTransferTransaction3() {

        Account sender = transactionalService.openAccount(new Account(100000L));
        Account receiver = transactionalService.openAccount(new Account(0L));

        Exception e = assertThrows(Exception.class, () -> {
            transactionalService.transfer(sender.getId(), 777L, 50000L);
        });

        assertThat(e.getMessage()).isEqualTo("Intentional RuntimeException");
        assertThat(transactionalService.getAccount(sender.getId()).getAmount()).isEqualTo(100000L);
        assertThat(transactionalService.getAccount(receiver.getId()).getAmount()).isEqualTo(0L);
    }

    @Test
    @DisplayName("이체: 송금인 업데이트 후 의도적인 Checked Exception")
    public void _14_testTransferTransaction4() {

        Account sender = transactionalService.openAccount(new Account(100000L));
        Account receiver = transactionalService.openAccount(new Account(0L));

        Exception e = assertThrows(Exception.class, () -> {
            transactionalService.transfer(sender.getId(), 555L, 50000L);
        });

        assertThat(e.getMessage()).isEqualTo("Intentional ClassNotFoundException");
        assertThat(transactionalService.getAccount(sender.getId()).getAmount()).isEqualTo(50000L);
        assertThat(transactionalService.getAccount(receiver.getId()).getAmount()).isEqualTo(0L);
    }

}
