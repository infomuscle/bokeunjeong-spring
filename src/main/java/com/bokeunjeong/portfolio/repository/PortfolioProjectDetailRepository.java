package com.bokeunjeong.portfolio.repository;

import com.bokeunjeong.portfolio.model.CompositeKey;
import com.bokeunjeong.portfolio.model.ProjectDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface PortfolioProjectDetailRepository extends JpaRepository<ProjectDetail, CompositeKey> {

}
