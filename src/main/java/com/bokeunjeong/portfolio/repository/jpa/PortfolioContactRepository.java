package com.bokeunjeong.portfolio.repository.jpa;

import com.bokeunjeong.portfolio.model.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioContactRepository extends JpaRepository<Contact, String> {

}
