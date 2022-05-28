package com.bokeunjeong.practice.jpa.repository;

import com.bokeunjeong.practice.jpa.model.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class CarRepository {

    private final EntityManager em;

    @Transactional
    public void save(Car car) {
        em.persist(car);
    }
}
