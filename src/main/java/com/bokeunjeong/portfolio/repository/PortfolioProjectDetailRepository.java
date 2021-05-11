package com.bokeunjeong.portfolio.repository;

import com.bokeunjeong.portfolio.model.base.CompositeKey;
import com.bokeunjeong.portfolio.model.ProjectDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioProjectDetailRepository extends JpaRepository<ProjectDetail, CompositeKey> {

}
