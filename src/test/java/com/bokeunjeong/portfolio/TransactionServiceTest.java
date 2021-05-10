package com.bokeunjeong.portfolio;

import com.bokeunjeong.portfolio.repository.PortfolioContactRepository;
import com.bokeunjeong.portfolio.service.TransactionService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("@Transactional 테스트")
public class TransactionServiceTest {

    @Autowired
    TransactionService transactionService;


    @Test
    @DisplayName("1. 트랜잭션 메소드 안에서 1개 insert 실행 중 예외")
    public void _01_testTransaction() {

        try {

            transactionService.addContact();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("2. 트랜잭션 메소드 안에서 n개 insert 실행 중 예외")
    public void _02_testTransaction() {

    }


    @Test
    @DisplayName("3. 논트랜잭션 메소드 안에서 1개 insert 실행 중 예외")
    public void _03_test() {

    }


}
