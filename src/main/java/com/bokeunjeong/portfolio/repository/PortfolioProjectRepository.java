package com.bokeunjeong.portfolio.repository;

import com.bokeunjeong.portfolio.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PortfolioProjectRepository extends JpaRepository<Project, String> {

    List<Project> findAllByDisplayOrderByIdDesc(Boolean display);

    List<Project> findAllByTypeOrderByIdDesc(String type);

}
