package com.bokeunjeong.portfolio.study;

import com.bokeunjeong.test.jpa.model.Car;
import com.bokeunjeong.test.jpa.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

@Slf4j
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
@ActiveProfiles("test")
public class PersistenceTest {

    @PersistenceUnit
    EntityManagerFactory emf;

    @Autowired
    CarRepository carRepository;


    @Test
    @DisplayName("[REPO] No Transaction")
    public void _01_testJpa() throws Exception {
        Car car = new Car();
        car.setManufacturer("Porsche");
        car.setModelName("Cayenne");

        carRepository.save(car);
    }

    @Test
    @Transactional
    @DisplayName("[REPO] Transaction")
    public void _02_testJpa() throws Exception {
        Car car = new Car();
        car.setManufacturer("BMW");
        car.setModelName("X5");

        carRepository.save(car);
    }

    @Test
    @DisplayName("[EMF] Manual Transaction")
    public void _11_testJpa() throws Exception {

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {

            Car car = new Car();
            car.setManufacturer("Hyundai");
            car.setModelName("Kona");

            em.persist(car);
//            em.flush();

            tx.commit();
        } catch (Exception e) {
            tx.rollback();

        } finally {
            em.close();
        }

//        emf.close();
    }

}
