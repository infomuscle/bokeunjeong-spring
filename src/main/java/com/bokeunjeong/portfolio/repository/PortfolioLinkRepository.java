package com.bokeunjeong.portfolio.repository;

import com.bokeunjeong.portfolio.model.entity.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioLinkRepository extends JpaRepository<Link, String> {
    public List<Link> findAllByDisplay(Boolean display);
}
