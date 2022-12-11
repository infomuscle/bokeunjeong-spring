package com.bokeunjeong.practice.pattern.strategy;

import com.bokeunjeong.practice.pattern.strategy.behavior.fly.FlyRocketPowered;
import com.bokeunjeong.practice.pattern.strategy.duck.Duck;
import com.bokeunjeong.practice.pattern.strategy.duck.MallardDuck;
import com.bokeunjeong.practice.pattern.strategy.duck.ModelDuck;
import org.junit.jupiter.api.Test;

public class StrategyTest {


    @Test
    void test1() {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }

    @Test
    void test2() {
        System.out.println("Fighter를 생성합니다.");
        Player player1 = new Fighter();
        player1.move();
        player1.attack();
        player1.sit();

        System.out.println();

        System.out.println("AssassinFighter를 생성합니다.");
        Player player2 = new AssassinFighter();
        player2.move();
        player2.attack();
        ((AssassinFighter) player2).switchMode();
        player2.move();
        player2.attack();
    }

    public abstract class Player {

        MoveBehavior moveBehavior;
        AttackBehavior attackBehavior;

        public void move() {
            moveBehavior.performMove();
        }

        public void attack() {
            attackBehavior.performAttack();
        }

        public void sit() {
            System.out.println("자리에 앉아 체력을 회복합니다.");
        }
    }


    public class Fighter extends Player {
        public Fighter() {
            this.moveBehavior = new WarriorMoveBehavior();
            this.attackBehavior = new FighterAttackBehavior();
        }
    }


    public class AssassinFighter extends Player {
        public AssassinFighter() {
            this.moveBehavior = new WarriorMoveBehavior();
            this.attackBehavior = new FighterAttackBehavior();
        }

        public void switchMode() {
            System.out.println("모드를 전환합니다.");
            this.moveBehavior = (this.moveBehavior instanceof WarriorMoveBehavior) ? new ThieifMoveBehavior() : new WarriorMoveBehavior();
            this.attackBehavior = (this.attackBehavior instanceof FighterAttackBehavior) ? new AssassinAttackBehavior() : new FighterAttackBehavior();
        }
    }



    public interface MoveBehavior {
        void performMove();
    }


    public class WarriorMoveBehavior implements MoveBehavior {
        public void performMove() {
            System.out.println("쿵쾅쿵쾅 움직입니다.");
        }
    }


    public class MagicianMoveBehavior implements MoveBehavior {
        public void performMove() {
            System.out.println("스르르륵 움직입니다.");
        }
    }


    public class ThieifMoveBehavior implements MoveBehavior {
        public void performMove() {
            System.out.println("슉슉슈슉 움직입니다.");
        }
    }


    public interface AttackBehavior {
        void performAttack();
    }


    public class FighterAttackBehavior implements AttackBehavior {
        public void performAttack() {
            System.out.println("칼로 벱니다.");
        }
    }


    public class SpearmanAttackBehavior implements AttackBehavior {
        public void performAttack() {
            System.out.println("창으로 찌릅니다.");
        }
    }


    public class AssassinAttackBehavior implements AttackBehavior {
        public void performAttack() {
            System.out.println("표창을 던집니다.");
        }
    }

}
