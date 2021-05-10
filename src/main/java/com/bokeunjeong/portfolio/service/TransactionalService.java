package com.bokeunjeong.portfolio.service;

import com.bokeunjeong.portfolio.model.Contact;
import com.bokeunjeong.portfolio.model.Project;
import com.bokeunjeong.portfolio.model.ProjectDetail;
import com.bokeunjeong.portfolio.repository.PortfolioContactRepository;
import com.bokeunjeong.portfolio.repository.PortfolioProjectDetailRepository;
import com.bokeunjeong.portfolio.repository.PortfolioProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        List<ProjectDetail> projectDetails = IntStream.rangeClosed(1, 3).mapToObj(i -> new ProjectDetail(true, project.getId(), i, "테스트" + String.valueOf(i))).collect(Collectors.toList());

        portfolioProjectRepository.save(project);

//        projectDetails.stream().forEach(pd -> portfolioProjectDetailRepository.save(pd));

    }


}
