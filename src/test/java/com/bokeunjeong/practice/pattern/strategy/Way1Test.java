package com.bokeunjeong.practice.pattern.strategy;

public class Way1Test {

    // public interface Player {
    //     void move();
    //
    //     void attack();
    //
    //     void sit();
    // }


    // 추상 부모 클래스
    public abstract class Player {

        // 추상 메소드는 각 직업 클래스에서 구현한다.
        public abstract void move();

        public abstract void attack();

        // 모든 직업 클래스는 똑같은 앉는 행동을 한다.
        public void sit() {
            System.out.println("자리에 앉아 체력을 10씩 회복합니다.");
        }

    }


    public class Warrior extends Player {

        public void move() {
            System.out.println("쿵쾅쿵쾅 움직입니다.");
        }

        public void attack() {
            System.out.println("슬래시 블러스트!");
        }

    }


    public class Magician extends Player {

        public void move() {
            System.out.println("스르르륵 움직입니다.");
        }

        public void attack() {
            System.out.println("매직 클로!");
        }

    }


    public class Thief extends Player {

        public void move() {
            System.out.println("슉슉슈슉 움직입니다.");
        }

        public void attack() {
            System.out.println("더블 스텝!");
        }

    }

}
