package com.bokeunjeong.portfolio.repository;

import com.bokeunjeong.portfolio.model.entity.Introduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioIntroductionRepository extends JpaRepository<Introduction, String> {
    public List<Introduction> findAllByDisplay(Boolean display);
}
