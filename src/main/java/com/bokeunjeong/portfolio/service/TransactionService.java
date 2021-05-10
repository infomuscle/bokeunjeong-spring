package com.bokeunjeong.portfolio.service;

import com.bokeunjeong.portfolio.model.Contact;
import com.bokeunjeong.portfolio.repository.PortfolioContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransactionService {


    private final PortfolioContactRepository portfolioContactRepository;

    public TransactionService(PortfolioContactRepository portfolioContactRepository) {
        this.portfolioContactRepository = portfolioContactRepository;
    }


    /**
     * Contact에 INSERT 후 예외
     */
    @Transactional
    public void addContact() throws Exception {

        List<Contact> contacts = portfolioContactRepository.findAll();
        Integer max = Integer.parseInt(contacts.get(contacts.size() - 1).getId().substring(1));

        Contact contact = new Contact();
        contact.setId("C" + String.format("%03d", max + 1));
        contact.setType("Github");
        contact.setDetail("https://github.com/infomuscle");

        portfolioContactRepository.save(contact);

//        throw new Exception("예외처리");

    }

    /**
     * Project + Project Detail INSERT 후 예외
     */
    @Transactional
    public void addProject() {

    }


}
