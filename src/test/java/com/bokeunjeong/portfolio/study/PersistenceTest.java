package com.bokeunjeong.portfolio.study;

import com.bokeunjeong.practice.jpa.model.Car;
import com.bokeunjeong.practice.jpa.repository.CarRepository;
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
@SpringBootTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.MethodName.class)
public class PersistenceTest {

    @PersistenceUnit
    EntityManagerFactory emf;

    @Autowired
    CarRepository carRepository;

    @Test
    @DisplayName("[동등성]")
    public void _00_testJpa() throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 같은 ID를 가진 인스턴스를 각각 생성
            Car car1 = new Car();
            car1.setId(1L);
            Car car2 = new Car();
            car2.setId(1L);
            System.out.println(car1 == car2);    // false

            // 영속성 컨텍스트를 통해 같은 ID를 가진 2개의 변수
            Car car = new Car();
            em.persist(car);
            Car car3 = em.find(Car.class, car.getId());
            Car car4 = em.find(Car.class, car.getId());
            System.out.println(car3 == car4);    // true

            tx.commit();
        } catch (Exception e) {
            log.info(e.getMessage(), e);
            tx.rollback();
        } finally {
            em.close();
        }
    }

    @Test
    @DisplayName("[Cache] First-level")
    public void _01_testJpa() throws Exception {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            System.out.println("STEP 1: 엔티티 생성 및 Persist");
            Car newCar = new Car();
            newCar.setManufacturer("Hyundai");
            newCar.setModelName("Kona");
            em.persist(newCar);
            System.out.println("========== newCar Persisted ==========");

            System.out.println("STEP 2: Flush/Clear 실행");
            // em.flush(); System.out.println("========== Flushed ==========");
            // em.clear(); System.out.println("========== Cleared ==========");

            System.out.println("STEP 3: newCar의 ID로 데이터 조회");
            Car kona = em.find(Car.class, newCar.getId());
            System.out.println(kona.getModelName() + " is made by " + kona.getManufacturer());

            System.out.println("STEP 4: 임의의 ID로 데이터 조회");
            Car cayenne = em.find(Car.class, 100L);
            System.out.println("========== cayenne Not Found ==========");

            System.out.println("STEP 5: 트랜잭션 커밋");
            tx.commit();
            System.out.println("========== Commit End ==========");
        } catch (Exception e) {
            log.info(e.getMessage(), e);
            tx.rollback();
        } finally {
            em.close();
        }
    }


    @Test
    @DisplayName("[REPO] No Transaction")
    public void _11_testJpa() throws Exception {
        Car car = new Car();
        car.setManufacturer("Porsche");
        car.setModelName("Cayenne");

        carRepository.save(car);
    }

    @Test
    @Transactional
    @DisplayName("[REPO] Transaction")
    public void _12_testJpa() throws Exception {
        Car car = new Car();
        car.setManufacturer("BMW");
        car.setModelName("X5");

        carRepository.save(car);
    }

    @Test
    @DisplayName("[EMF] Manual Transaction")
    public void _13_testJpa() throws Exception {

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
