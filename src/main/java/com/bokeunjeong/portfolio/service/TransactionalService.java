package com.bokeunjeong.portfolio.service;

import com.bokeunjeong.portfolio.model.Contact;
import com.bokeunjeong.portfolio.model.Project;
import com.bokeunjeong.portfolio.repository.PortfolioContactRepository;
import com.bokeunjeong.portfolio.repository.PortfolioProjectDetailRepository;
import com.bokeunjeong.portfolio.repository.PortfolioProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TransactionalService {


    private final PortfolioContactRepository portfolioContactRepository;
    private final PortfolioProjectRepository portfolioProjectRepository;
    private final PortfolioProjectDetailRepository portfolioProjectDetailRepository;

    public TransactionalService(PortfolioContactRepository portfolioContactRepository, PortfolioProjectRepository portfolioProjectRepository, PortfolioProjectDetailRepository portfolioProjectDetailRepository) {
        this.portfolioContactRepository = portfolioContactRepository;
        this.portfolioProjectRepository = portfolioProjectRepository;
        this.portfolioProjectDetailRepository = portfolioProjectDetailRepository;
    }


    /**
     * Contact에 INSERT 후 예외
     */
    @Transactional(rollbackFor = {Exception.class})
    public void deposit(Contact contact) throws Exception {

    }

    /**
     * Project + Project Detail INSERT 후 예외
     */
    @Transactional
    public void transfer(String sendAccount, String receiveAccount, Integer amount) {

    }

}
