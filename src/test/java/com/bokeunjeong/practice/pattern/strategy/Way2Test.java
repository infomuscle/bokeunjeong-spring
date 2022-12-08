package com.bokeunjeong.practice.pattern.strategy;

public class Way2Test {

    public abstract class Player {

        public abstract void move();

        public abstract void attack();

        public void sit() {
            System.out.println("자리에 앉아 체력을 회복합니다.");
        }
    }


    public abstract class Warrior extends Player {
        public void move() {
            System.out.println("쿵쾅쿵쾅 움직입니다.");
        }
    }


    public class Fighter extends Warrior {
        public void attack() {
            System.out.println("칼로 벱니다.");
        }
    }


    public class Spearman extends Warrior {
        public void attack() {
            System.out.println("창으로 찌릅니다.");
        }
    }


    public abstract class Magician extends Player {
        public void move() {
            System.out.println("스르르륵 움직입니다.");
        }
    }


    public abstract class Thief extends Player {
        public void move() {
            System.out.println("슉슉슈슉 움직입니다.");
        }
    }
}
