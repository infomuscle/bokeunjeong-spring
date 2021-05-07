package com.bokeunjeong.portfolio.service;

import com.bokeunjeong.portfolio.model.Contact;
import com.bokeunjeong.portfolio.repository.PortfolioContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    private final PortfolioContactRepository portfolioContactRepository;

    @Autowired
    public PortfolioService(PortfolioContactRepository portfolioContactRepository) {
        this.portfolioContactRepository = portfolioContactRepository;
    }

    public List<Contact> getContacts() {

        return  portfolioContactRepository.findAll();
    }

}
