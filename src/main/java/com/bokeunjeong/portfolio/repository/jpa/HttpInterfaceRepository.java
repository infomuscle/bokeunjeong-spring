package com.bokeunjeong.portfolio.repository.jpa;

import com.bokeunjeong.portfolio.model.entity.Contact;
import com.bokeunjeong.portfolio.model.entity.HttpInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HttpInterfaceRepository extends JpaRepository<HttpInterface, Long> {

}
