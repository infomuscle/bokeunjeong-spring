package com.bokeunjeong.portfolio.repository;

import com.bokeunjeong.portfolio.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioContactRepository extends JpaRepository<Contact, String> {

}
