package com.bokeunjeong.portfolio.service;

import com.bokeunjeong.portfolio.model.Contact;
import com.bokeunjeong.portfolio.repository.PortfolioContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class TransactionalService {


    private final PortfolioContactRepository portfolioContactRepository;

    public TransactionalService(PortfolioContactRepository portfolioContactRepository) {
        this.portfolioContactRepository = portfolioContactRepository;
    }


    /**
     * Contact에 INSERT 후 예외
     */
//    @Transactional
    @Transactional(rollbackFor = {Exception.class})
    public void addContact(Contact contact) throws Exception {

        portfolioContactRepository.save(contact);
        throw new Exception("예외처리");

    }

    /**
     * Project + Project Detail INSERT 후 예외
     */
    @Transactional
    public void addProject() {

    }


}
