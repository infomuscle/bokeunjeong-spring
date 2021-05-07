package com.bokeunjeong.portfolio.repository;

import com.bokeunjeong.portfolio.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioProjectRepository extends JpaRepository<Project, String> {

}
