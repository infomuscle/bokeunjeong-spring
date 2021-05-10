package com.bokeunjeong.portfolio.service;

import com.bokeunjeong.portfolio.model.Contact;
import com.bokeunjeong.portfolio.model.Project;
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
//    @Transactional(rollbackFor = {Exception.class})
    public void addProject(Project project) {

        log.info(project.toString());

        portfolioProjectRepository.save(project);

    }


}
