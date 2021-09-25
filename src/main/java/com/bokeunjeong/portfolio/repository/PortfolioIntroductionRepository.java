package com.bokeunjeong.portfolio.repository;

import com.bokeunjeong.portfolio.model.Introduction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioIntroductionRepository extends JpaRepository<Introduction, String> {

    public List<Introduction> findAllByDisplay(Boolean display);

}
