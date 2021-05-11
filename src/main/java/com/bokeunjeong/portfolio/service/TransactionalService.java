package com.bokeunjeong.portfolio.service;

import com.bokeunjeong.portfolio.model.Contact;
import com.bokeunjeong.portfolio.repository.PortfolioContactRepository;
import com.bokeunjeong.portfolio.repository.PortfolioProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TransactionalService {


    private final PortfolioContactRepository portfolioContactRepository;
    private final PortfolioProjectRepository portfolioProjectRepository;

    public TransactionalService(PortfolioContactRepository portfolioContactRepository, PortfolioProjectRepository portfolioProjectRepository) {
        this.portfolioContactRepository = portfolioContactRepository;
        this.portfolioProjectRepository = portfolioProjectRepository;
    }


    @Transactional(rollbackFor = {Exception.class})
    public void deposit(Contact contact) throws Exception {

    }

    @Transactional
    public void transfer(String sendAccount, String receiveAccount, Integer amount) {

    }

}
