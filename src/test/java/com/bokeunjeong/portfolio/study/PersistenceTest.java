package com.bokeunjeong.portfolio.study;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Slf4j
@ActiveProfiles("test")
public class PersistenceTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void testJpa() throws Exception {


    }

}
