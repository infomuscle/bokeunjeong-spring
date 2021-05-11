package com.bokeunjeong.portfolio.study;

import com.bokeunjeong.portfolio.test.transaction.model.Account;
import com.bokeunjeong.portfolio.test.transaction.service.AccountService;
import org.junit.jupiter.api.*;
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

    private Account sender;
    private Account receiver;

    @BeforeEach
    public void beforeEach() {
        sender = accountService.openAccount(new Account(100000L));
        receiver = accountService.openAccount(new Account(0L));
    }

    @Test
    @DisplayName("이체: 정상")
    public void _11_testTransferTransaction() throws Exception {

        Map<String, Account> result = accountService.transfer(sender.getId(), receiver.getId(), 50000L);

        assertThat(result.get("sender").getAmount()).isEqualTo(50000L);
        assertThat(result.get("receiver").getAmount()).isEqualTo(50000L);
    }

    @Test
    @DisplayName("이체: 송금인 업데이트 후 예상못한 Unchecked Exception")
    public void _12_testTransferTransaction2() {

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

        Exception e = assertThrows(Exception.class, () -> {
            accountService.transfer(sender.getId(), 555L, 50000L);
        });

        assertThat(e.getMessage()).isEqualTo("Intentional ClassNotFoundException");
        assertThat(accountService.getAccount(sender.getId()).getAmount()).isEqualTo(50000L);
        assertThat(accountService.getAccount(receiver.getId()).getAmount()).isEqualTo(0L);
    }

    @Test
    @DisplayName("이체: 전체 완료 후 예상못한 Unchecked Exception")
    public void _15_testTransferTransaction5() {

        Exception e = assertThrows(Exception.class, () -> {
            accountService.transfer(sender.getId(), 333L, 50000L);
        });

        assertThat(e.getClass().getSimpleName()).isEqualTo("NullPointerException");
        assertThat(accountService.getAccount(sender.getId()).getAmount()).isEqualTo(100000L);
        assertThat(accountService.getAccount(receiver.getId()).getAmount()).isEqualTo(0L);
    }

    @Test
    @DisplayName("이체: 전체 완료 후 의도적인 Checked Exception")
    public void _16_testTransferTransaction6() {

        Account sender = accountService.openAccount(new Account(100000L));
        Account receiver = accountService.openAccount(new Account(0L));

        Exception e = assertThrows(Exception.class, () -> {
            accountService.transfer(sender.getId(), 222L, 50000L);
        });

        assertThat(e.getMessage()).isEqualTo("Intentional Checked Exception");
        assertThat(accountService.getAccount(sender.getId()).getAmount()).isEqualTo(50000L);
        assertThat(accountService.getAccount(receiver.getId()).getAmount()).isEqualTo(0L);
    }


}
